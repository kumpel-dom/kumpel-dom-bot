package parser

import org.json.JSONObject
import org.omg.CORBA.StringHolder
import java.lang.*
import java.util.*
import kotlin.annotation.*

class JsonParser {

    fun jsonParser(json: JSONObject?): String? {
        val parsed = json
        var denovo = parsed?.getJSONArray("node")?.getJSONObject(0)?.getJSONArray("area")?.getJSONObject(0)?.get("areaname")
        return "$denovo"
    }

    /*
    fun parserNode(json: JSONObject?): ArrayList<String>? {
        val parsed = json
        var nodes
        for (x in parsed?.getJSONArray("node")!!){

        }
    }
    */
}

