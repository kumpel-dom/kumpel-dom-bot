package parser

import com.kumpel.dom.bot.model.Node
import org.json.JSONObject

class NodeParser {

    fun nodeParser(json: JSONObject?): ArrayList<Node> {
        val list = ArrayList<Node>()
        val length: Int = CompanionObjects.nodeLength(json)
        var i = 0
        while (i < length) {
            val node = Node()
            node.setId(CompanionObjects.nodeid(json, i))
            node.setName(CompanionObjects.nodename(json, i))
            list.add(node)
            i++
        }

        return list
    }
}