group = "app.revanced"

patches {
    about {
        name = "Liaralabs ReVanced Patches"
        description = "Liaralabs Patches template for ReVanced"
        source = "git@github.com:liaralabs/revanced-patches.git"
        author = "Liaralabs"
        contact = "liara@swizzin.ltd"
        website = "https://nulldev.foo"
        license = "GNU General Public License v3.0"
    }
}


kotlin {
    compilerOptions {
        freeCompilerArgs = listOf("-Xcontext-receivers")
    }
}