package parser

import org.json.JSONObject

class CompanionObjects {

    companion object {

        fun nodeLength(json: JSONObject?): Int {
            return json?.getJSONArray("node")?.length()!!.toInt()
        }

        fun nodeid(json: JSONObject?, i: Int): Int {
            return json?.getJSONArray("node")?.getJSONObject(i)?.getInt("nodeid")!!
        }

        fun nodename(json: JSONObject?, i: Int): String {
            return json?.getJSONArray("node")?.getJSONObject(i)?.getString("nodename")!!
        }

        fun areaLength(json: JSONObject?, i: Int): Int {
            return json?.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.length()!!.toInt()
        }

        fun areaid(json: JSONObject?, i: Int, j: Int): Int {
            return json?.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.getJSONObject(j)?.getInt("areaid")!!
        }

        fun areaname(json: JSONObject?, i: Int, j: Int): String? {
            return json?.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.getJSONObject(j)?.getString("areaname")
        }

        fun actionLength(json: JSONObject?, i: Int, j: Int): Int {
            return json?.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.getJSONObject(j)?.getJSONArray("action")?.length()!!.toInt()
        }

        fun actionid(json: JSONObject?, i: Int, j: Int, k: Int): Int {
            return json?.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.getJSONObject(j)?.getJSONArray("action")?.getJSONObject(k)?.getInt("actionid")!!
        }

        fun actionname(json: JSONObject?, i: Int, j: Int, k: Int): String? {
            return json?.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.getJSONObject(j)?.getJSONArray("action")?.getJSONObject(k)?.getString("actionname")
        }

    }
}