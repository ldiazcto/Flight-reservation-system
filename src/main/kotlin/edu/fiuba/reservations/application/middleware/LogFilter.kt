package edu.fiuba.reservations.application.middleware

import edu.fiuba.reservations.config.context.HeaderType
import edu.fiuba.reservations.logger
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.MDC
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.util.UUID
import javax.annotation.Priority

@Priority(1)
@Component
class LogFilter(
    @Value("\${reservations.endpoints.notFilter}")
    private val endpointsNotToFilter: ArrayList<String>
) : OncePerRequestFilter() {
    val log by logger()

    @Throws(java.io.IOException::class, ServletException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        try {
            val token = determineCorrelationId(request)
            MDC.put(DEFAULT_MDC_UUID_TOKEN_KEY, token)
            response.addHeader(DEFAULT_RESPONSE_TOKEN_HEADER, token)
            log.info(getRequestMessage(request))
            chain.doFilter(request, response)
            log.info(getResponseMessage(response, request))
        } finally {
            MDC.remove(DEFAULT_MDC_UUID_TOKEN_KEY)
        }
    }

    override fun isAsyncDispatch(request: HttpServletRequest): Boolean {
        return false
    }

    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
        return endpointsNotToFilter.any { request.requestURI.contains(it) }
    }

    override fun shouldNotFilterErrorDispatch(): Boolean {
        return false
    }

    private fun determineCorrelationId(request: HttpServletRequest): String {
        var correlationId = request.getHeader(HeaderType.REQUEST_ID.label)

        if (correlationId.isNullOrBlank()) {
            correlationId = generateCorrelationId()
        }

        return correlationId
    }

    private fun generateCorrelationId(): String {
        return UUID.randomUUID().toString()
    }

    private fun getRequestMessage(request: HttpServletRequest): String {
        val headerValues = generateHeaderValues(request)
        val requestMessage = listOfNotNull(request.method, request.requestURI, request.queryString, headerValues)
            .reduce { acc, requestItem -> "$acc $requestItem" }

        return "IN >>> $requestMessage"
    }

    private fun getResponseMessage(response: HttpServletResponse, request: HttpServletRequest): String {
        val statusCode = response.status
        val contentType = response.contentType
        val method = request.method
        val path = request.requestURI

        return "OUT <<< $method $path HTTP $statusCode ${HttpHeaders.CONTENT_TYPE}:$contentType"
    }

    fun generateHeaderValues(request: HttpServletRequest): String {
        val headerNames = request.headerNames.toList()

        val headerValues = headerNames.fold(String()) { acc, headerName ->
            "$acc{$headerName: ${request.getHeader(headerName)}}"
        }

        return headerValues
    }

    companion object {
        private const val DEFAULT_RESPONSE_TOKEN_HEADER = "Response-Token"
        private const val DEFAULT_MDC_UUID_TOKEN_KEY = "LogMDCFilter.UUID"
    }
}
