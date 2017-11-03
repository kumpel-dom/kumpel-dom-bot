package parser

import com.kumpel.dom.bot.model.Area
import org.json.JSONObject

/**
 *
 * This class parse the json received from the server/IoT(depends on the phase of the project)
 * and add to a list
 *
 * @author alexNeto
 *
 * @param json the type is a JSONObject
 * @return returns a list of Area
 */
class AreaParser {

    fun areaParser(json: JSONObject?): ArrayList<Area> {
        val list = ArrayList<Area>()
        /**
         * Iterates over the node and area arrays in the json document
         */
        var i = 0
        while (i < CompanionObjects.nodeLength(json)) {
            var j = 0
            while (j < CompanionObjects.areaLength(json, i)) {
                /**
                 * Create a nre Area object
                 * then set its areaid, areaname and nodeid to the parsed from json
                 */
                val area = Area()
                area.setId(CompanionObjects.areaid(json, i, j))
                area.setName(CompanionObjects.areaname(json, i, j))
                area.foreignid = CompanionObjects.nodeid(json, i)
                list.add(area)
                j++
            }
            i++
        }
        return list
    }
}