package parser

import com.kumpel.dom.bot.model.pojo.Action
import org.json.JSONObject

/**
 *
 * This class parse the json received from the server/IoT(depends on the phase of the project)
 * and add to a list
 *
 * @author alexNeto
 *
 * @param json the type is a JSONObject
 * @return returns a list of Action
 */
class ActionParser {

    fun actionParser(json: JSONObject): ArrayList<Action> {
        val list = ArrayList<Action>()
        /**
         * Iterates over the node, area and action arrays in the json document
         */
        var i = 0
        while (i < CompanionObjects.nodeLength(json)) {
            var j = 0
            while (j < CompanionObjects.areaLength(json, i)) {
                var k = 0
                while (k < CompanionObjects.actionLength(json, i, j)) {
                    /**
                     * Create a nre Area object
                     * then set its actionid, actionname and areaid to the parsed from json
                     */
                    val action = Action()
                    action.id = CompanionObjects.actionid(json, i, j, k)
                    action.name = CompanionObjects.actionname(json, i, j, k)
                    action.foreignId = CompanionObjects.areaid(json, i, j)
                    action.state = CompanionObjects.state(json, i, j, k)
                    list.add(action)
                    k++
                }
                j++
            }
            i++
        }
        return list
    }

}