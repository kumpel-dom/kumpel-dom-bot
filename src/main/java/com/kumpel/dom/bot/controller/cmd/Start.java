package com.kumpel.dom.bot.controller.cmd;

import com.kumpel.dom.bot.model.bd.dao.*;
import com.kumpel.dom.bot.model.pojo.Action;
import com.kumpel.dom.bot.model.pojo.Area;
import com.kumpel.dom.bot.model.pojo.Node;
import org.telegram.telegrambots.api.methods.send.SendMessage;

import java.util.Iterator;
import java.util.List;

public class Start implements JsonGetInterface {

    public Start() {
        createNodes();
        createAreas();
        createActions();
    }

    private void createNodes() {
        List<Node> list = new parser.NodeParser().nodeParser(json);

        Iterator<Node> ite = list.iterator();
        while (ite.hasNext()) {
            new NodeDAO().create(ite.next());
        }
    }

    private void createAreas() {
        List<Area> list = new parser.AreaParser().areaParser(json);

        Iterator<Area> ite = list.iterator();
        while (ite.hasNext()) {
            new AreaDAO().create(ite.next());
        }
    }

    private void createActions() {
        List<Action> list = new parser.ActionParser().actionParser(json);

        Iterator<Action> ite = list.iterator();
        while (ite.hasNext()) {
            new ActionDAO().create(ite.next());
        }
    }

    public static SendMessage start(long chatId){
        StringBuilder answer = new StringBuilder();
        answer.append("Inicializando Banco de dados: ✔️\n️");
        answer.append("Sincronizando: ✔️\n");
        answer.append("Idioma: \uD83C\uDDE7\uD83C\uDDF7\n");
        //answer.append("Inicializando IA: ✔️\n️");
        answer.append("\n\nBot inicializado com sucesso \uD83D\uDE4C");
        return new SendMessage().setChatId(chatId).setText(answer.toString());
    }
}
