package parser

import com.google.common.collect.Maps
import org.json.JSONObject
import java.util.*

class JsonParser {

    fun jsonParser(json: JSONObject?): String? {
        val parsed = json
        var denovo = parsed?.getJSONArray("node")?.getJSONObject(0)?.getJSONArray("area")?.getJSONObject(0)?.get("areaname")
        return "$denovo"
    }

    fun parserNode(json: JSONObject?): HashMap<Int?, String?> {
        var key: Int?
        var value: String?
        val map: HashMap<Int?, String?> = HashMap()
        var x: Int = 0

        while (x < json?.getJSONArray("node")?.length()!!.toInt()) {
            key = json.getJSONArray("node")?.getJSONObject(x)?.getInt("nodeid")
            value = json.getJSONArray("node")?.getJSONObject(x)?.getString("nodename")
            map.put(key, value)
            x++
        }
        return map
    }

    fun nodeid(json: JSONObject?, i: Int): String {

        return json?.getJSONArray("node")?.getJSONObject(i)?.getInt("nodeid")!!.toString()
    }

    fun areaid(json: JSONObject?, i: Int, j: Int): String {
        return json?.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.getJSONObject(j)?.get("areaid")!!.toString()
    }

    fun areaname(json: JSONObject?, i: Int, j: Int): String? {
        return json?.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.getJSONObject(j)?.getString("areaname")
    }

    fun parserArea(json: JSONObject?, node: Int?): HashMap<String?, String?> {
        val map: HashMap<String?, String?> = HashMap()
        var key: String?
        var value: String?
        val length: Int = json?.getJSONArray("node")?.length()!!.toInt()

        var i: Int = 0
        if (node == -1) {
            while (i < length) {
                var j: Int = 0
                while (j < json.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.length()!!.toInt()) {
                    key = """${nodeid(json, i)}."""
                    key += """${areaid(json, i, j)}"""
                    value = areaname(json, i, j)
                    map.put(key, value)
                    j++
                }
                i++
            }
        } else {
            while (i < json.getJSONArray("node")?.getJSONObject(node!!)?.getJSONArray("area")?.length()!!.toInt()) {
                key = """${nodeid(json, node!!)}."""
                key += """${areaid(json, node, i)}"""
                value = areaname(json, node, i)
                map.put(key, value)
                i++
            }
        }
        return map
    }

    fun parserActions(json: JSONObject?, node: Int?): HashMap<String?, String?> {
        val map: HashMap<String?, String?> = HashMap()
        var key: String?
        var value: String?
        val length: Int = json?.getJSONArray("node")?.length()!!.toInt()

        var i: Int = 0
        if (node == -1) {
            while (i < length) {
                var j: Int = 0
                while (j < json.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.length()!!.toInt()) {
                    key = """${nodeid(json, i)}."""
                    key += """${areaid(json, i, j)}"""
                    value = areaname(json, i, j)
                    map.put(key, value)
                    j++
                }
                i++
            }
        } else {
            while (i < json.getJSONArray("node")?.getJSONObject(node!!)?.getJSONArray("area")?.length()!!.toInt()) {
                key = """${nodeid(json, node!!)}."""
                key += """${areaid(json, node, i)}"""
                value = areaname(json, node, i)
                map.put(key, value)
                i++
            }
        }
        return map
    }
}

