package parser

import com.kumpel.dom.bot.model.Area
import org.json.JSONObject

class AreaParser {

    fun areaParser(json: JSONObject?): ArrayList<Area> {
        val list = ArrayList<Area>()
        var i = 0
        while (i < CompanionObjects.nodeLength(json)) {
            var j = 0
            while (j < CompanionObjects.areaLength(json, i)) {
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