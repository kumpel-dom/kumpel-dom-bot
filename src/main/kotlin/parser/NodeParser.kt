package parser

import com.kumpel.dom.bot.model.Node
import org.json.JSONObject

/**
 *
 * This class parse the json received from the server/IoT(depends on the phase of the project)
 * and add to a list
 *
 * @author alexNeto
 *
 * @param json the type is a JSONObject
 * @return returns a list of Node
 */
class NodeParser {

    fun nodeParser(json: JSONObject?): ArrayList<Node> {
        val list = ArrayList<Node>()
        /**
         * Call a static method which returns the
         * length of the "node" array in the json document
         */
        val length: Int = CompanionObjects.nodeLength(json)!!
        var i = 0
        while (i < length) {
            /**
             * Create a new object of the type Node
             * then set its nodeid and nodename to the
             * specified in the received json
             */
            val node = Node()
            node.setId(CompanionObjects.nodeid(json, i)!!)
            node.setName(CompanionObjects.nodename(json, i))
            list.add(node)
            i++
        }

        return list
    }
}