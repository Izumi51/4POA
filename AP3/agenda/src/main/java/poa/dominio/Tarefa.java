package poa.dominio;

import com.sun.source.tree.UsesTree;

public class Tarefa {

    private String jogo;
    private String data;
    private String nickname;

    public Tarefa(String jogo, String data, String nickname) {
        super();
        this.jogo = jogo;
        this.data = data;
        this.nickname = nickname;
    }

    public String getData() {
        return data;
    }

    public String getJogo() {
        return jogo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setJogo(String jogo) {
        this.jogo = jogo;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void listarTarefa() {
        System.out.println("\n\tNome do Jogo: " + jogo + "\n\tData do jogo: " + data + "\n\tNickname do amigo: " + nickname );
    }
}
