class DirectoryExplorer(val user: String) {

    inner class PermissionCheck() {
        
        fun validatePermission(user: String) {
            println("Validating $user")
        }

        // Accessing outer class properties since nested class is prefixed with `inner`
        fun anotherValidation() {
            if (user == "Arunav")
                println("Allow Something to $user")
        }
    }

    fun listFolder(folder: String, user: String) {
        var permissionCheck = PermissionCheck()
        permissionCheck.validatePermission(user)
    }
}

fun main() {

    val directoryExplorer = DirectoryExplorer("Madhuri")

    directoryExplorer.listFolder("foldername", "Madhuri")

    val permissionCheck = DirectoryExplorer("Arunav").PermissionCheck()
    permissionCheck.anotherValidation()


}