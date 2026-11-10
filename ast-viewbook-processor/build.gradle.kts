plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(ast.ksp.symbol.processing.api)
}
