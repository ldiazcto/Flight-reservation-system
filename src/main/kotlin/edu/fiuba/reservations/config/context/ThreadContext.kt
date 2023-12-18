package edu.fiuba.reservations.config.context

import kotlinx.coroutines.asContextElement

object ThreadContext {
    private val THREAD_CONTEXT_REQUEST: ThreadLocal<Request> =
        ThreadLocal.withInitial { Request(String(), mapOf()) }

    var request: Request
        get() = THREAD_CONTEXT_REQUEST.get()
        set(value) {
            THREAD_CONTEXT_REQUEST.set(value)
        }

    fun getContext() = THREAD_CONTEXT_REQUEST.asContextElement()

    fun clear() = THREAD_CONTEXT_REQUEST.remove()
}
