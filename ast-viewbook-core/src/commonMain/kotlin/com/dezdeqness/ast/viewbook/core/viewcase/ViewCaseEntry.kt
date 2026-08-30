package com.dezdeqness.ast.viewbook.core.viewcase

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class ViewCaseEntry(
    val name: String = "",
    val path: Array<String> = [],
)
