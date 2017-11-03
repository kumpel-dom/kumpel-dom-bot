package parser

import com.kumpel.dom.bot.model.Action
import org.json.JSONObject

class ActionParser {

    fun actionParser(json: JSONObject): ArrayList<Action> {
        val list = ArrayList<Action>()
        var i = 0
        while (i < CompanionObjects.nodeLength(json)) {
            var j = 0
            while (j < CompanionObjects.areaLength(json, i)) {
                var k = 0
                while (k < CompanionObjects.actionLength(json, i, j)) {
                    val action = Action()
                    action.setId(CompanionObjects.actionid(json, i, j, k))
                    action.setName(CompanionObjects.actionname(json, i, j, k))
                    action.foreignid = CompanionObjects.areaid(json, i, j)
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