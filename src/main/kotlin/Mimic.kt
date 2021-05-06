import java.net.URL

class Mimic {


    var mimicCharacters:String = ""

    fun processMimicCharacterSet() {
        mimicCharacters = getMimicCharacterSet()
        //mimicCharacters = "zztop"
    }

    private fun getMimicCharacterSet(): String {
        var errorMessage = "";
        try {
            val path = "MimicCharacterSet.txt"
            val resource = Thread.currentThread().contextClassLoader.getResource(path)
            //requireNotNull(resource) { "Resource $path not found" }

            return resource.readText()
        } catch (e: Exception) {
            errorMessage = e.message?: "Unknown Error"
        }
        return errorMessage
    }
}