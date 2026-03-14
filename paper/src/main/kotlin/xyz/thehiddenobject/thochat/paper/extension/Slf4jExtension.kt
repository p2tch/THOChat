package xyz.thehiddenobject.thochat.paper.extension

import org.slf4j.Logger
import org.slf4j.LoggerFactory

inline fun <reified T : Any> T.slf4j(): Lazy<Logger> =
    lazy { LoggerFactory.getLogger(T::class.java) }