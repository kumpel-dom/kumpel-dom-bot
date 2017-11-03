package parser

import org.json.JSONObject
import javax.validation.constraints.Null

/**
 *
 * This class have a set of static methods to help DRY the parse
 *
 * @author alexNeto
 *
 */
class CompanionObjects {

    companion object {

        /**
         * This static method parse the length of the node array from the json document
         *
         * @author alexNeto
         *
         * @param json the type is a JSONObject
         * @return length of the node array
         */
        fun nodeLength(json: JSONObject?): Int {
            try {
                return json?.getJSONArray("node")?.length()!!
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
            return 0
        }

        /**
         * This static method parse ids from the node array of the json document
         *
         * @author alexNeto
         *
         * @param json the type is a JSONObject
         * @param i Int type, the index for the array
         * @return nodeid from parser json
         */
        fun nodeid(json: JSONObject?, i: Int): Int {
            try {
                return json?.getJSONArray("node")?.getJSONObject(i)?.getInt("nodeid")!!
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
            return 0
        }

        /**
         * This static method parse names from the node array of the json document
         *
         * @author alexNeto
         *
         * @param json the type is a JSONObject
         * @param i Int type, the index for the array
         * @return nodename from parser json
         */
        fun nodename(json: JSONObject?, i: Int): String {
            try {
                return json?.getJSONArray("node")?.getJSONObject(i)?.getString("nodename")!!
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
            return ""
        }

        /**
         * This static method parse the length of the area array from the json document
         *
         * @author alexNeto
         *
         * @param json the type is a JSONObject
         * @param i Int type, the index for the array
         * @return length of the area array
         */
        fun areaLength(json: JSONObject?, i: Int): Int {
            try{
                return json?.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.length()!!
            } catch (e: NullPointerException){
                e.printStackTrace()
            }
            return 0
        }


        /**
         * This static method parse ids from the area array of the json document
         *
         * @author alexNeto
         *
         * @param json the type is a JSONObject
         * @param i Int type, the index for the array
         * @param j Int type, the index for the inner array
         * @return areaid from parser json
         */
        fun areaid(json: JSONObject?, i: Int, j: Int): Int {
            try {
                return json?.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.getJSONObject(j)?.getInt("areaid")!!
            } catch (e: NullPointerException){
                e.printStackTrace()
            }
            return 0
        }

        /**
         * This static method parse names from the area array of the json document
         *
         * @author alexNeto
         *
         * @param json the type is a JSONObject
         * @param i Int type, the index for the array
         * @param j Int type, the index for the inner array
         * @return areaname from parser json
         */
        fun areaname(json: JSONObject?, i: Int, j: Int): String {
            try{
                return json?.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.getJSONObject(j)?.getString("areaname")!!
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
            return ""
        }

        /**
         * This static method parse the length of the action array from the json document
         *
         * @author alexNeto
         *
         * @param json JSONObject type, the json to be parsed
         * @param i Int type, the index for the array
         * @param j Int type, the index for the array inside the array
         * @return length of the area array
         */
        fun actionLength(json: JSONObject?, i: Int, j: Int): Int {
            try {
                return json?.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.getJSONObject(j)?.getJSONArray("action")?.length()!!
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
            return 0
        }

        /**
         * This static method parse ids from the action array of the json document
         *
         * @author alexNeto
         *
         * @param json the type is a JSONObject
         * @param i Int type, the index for the array
         * @paran j Int type, the index of the inner array
         * @param k Int type, the index of the inner inner array
         * @return actionid from parser json
         */
        fun actionid(json: JSONObject?, i: Int, j: Int, k: Int): Int {
            try {
                return json?.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.getJSONObject(j)?.getJSONArray("action")?.getJSONObject(k)?.getInt("actionid")!!
            } catch (e: NullPointerException){
                e.printStackTrace()
            }
            return 0
        }

        /**
         * This static method parse names from the action array of the json document
         *
         * @author alexNeto
         *
         * @param json the type is a JSONObject
         * @param i Int type, the index for the array
         * @param j Int type, the index for the inner array
         * @param k Int type, the index for the inner inner array
         * @return actionname from parser json
         */
        fun actionname(json: JSONObject?, i: Int, j: Int, k: Int): String {
            try {
                return json?.getJSONArray("node")?.getJSONObject(i)?.getJSONArray("area")?.getJSONObject(j)?.getJSONArray("action")?.getJSONObject(k)?.getString("actionname")!!
            } catch (e: NullPointerException){
                e.printStackTrace()
            }
            return ""

        }

    }
}