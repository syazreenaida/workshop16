package vttp2022.ssfworkshop16.model;

import java.io.Serializable;

public class Pieces implements Serializable{
    private static final long serialVersionUID = 1L;
    private Rulebook rulebook;
    private Board board;
    private Discs discs;

    public Rulebook getRulebook() { return rulebook; }
    public void setRulebook(Rulebook value) { this.rulebook = value; }

    public Board getBoard() { return board; }
    public void setBoard(Board value) { this.board = value; }

    public Discs getDiscs() { return discs; }
    public void setDiscs(Discs value) { this.discs = value; }
}
