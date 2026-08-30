package com.dezdeqness.ast.viewbook.core.viewcase

@Target(AnnotationTarget.FILE)
@Retention(AnnotationRetention.SOURCE)
annotation class Folder(vararg val path: String)
