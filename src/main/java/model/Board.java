package model;

import java.util.regex.Matcher;

public class Board {
    private Player turn;
    private Phase phase;
    private PlayBoard playBoard1;
    private PlayBoard playBoard2;




    public MonsterCard selectMonster(int number,PlayBoard playBoard)
    {
        return (MonsterCard) playBoard.getMonsters().get(number);

    }

    public Card selectSpellOrTrap(int number,PlayBoard playBoard)
    {
        return  playBoard.getSpellTrap().get(number);

    }

    public Card selectFromHand(int number)
    {
        return getPlayBoardByTurn().getHand().get(number);


    }

    @Override
    public String toString() {
        return "Board{" +
                "player1=" + playBoard1.getPlayer() +
                ", turn=" + turn +
                ", phase='" + phase + '\'' +
                ", playboard1=" + playBoard1 +
                ", player2=" + playBoard2.getPlayer() +
                ", playboard2=" + playBoard2 +
                '}';
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public void changePhase(Phase phase)
    {
        switch (phase){
            case DRAW:
                setPhase(Phase.STANDBY);
                break;
            case STANDBY:
                setPhase(Phase.MAIN1);
                break;
            case MAIN1:
                setPhase(Phase.BATTLE);
                break;
            case BATTLE:
                setPhase(Phase.MAIN2);
                break;
            case MAIN2:setPhase(Phase.END);
        }

    }

    public void reverseTurn()
    {
        if(playBoard2.getPlayer().getNickname().equals(turn.getNickname())){
            turn=playBoard1.getPlayer();
        }
        else turn=playBoard2.getPlayer();

    }
    public PlayBoard getPlayBoardByTurn(){
        if(turn.getNickname().equals(playBoard1.getPlayer().getNickname()))
            return playBoard1;
        else return playBoard2;
    }

    public void addToGrave(Card card,PlayBoard playBoard)
    {
        playBoard.getGraveyards().add(card);


    }

    public void reverseBoard(String turn)
    {

    }

    public void addToHand(PlayBoard playBoard)
    {
        Card card=playBoard.getDeck().getMainDeck().get(0);
        playBoard.getHand().add(card);
        playBoard.getDeck().getMainDeck().remove(0);

    }

    public void addToMonster(Card card)
    {

    }

    public void addToSpell(Card card)
    {

    }

    public void removeToGrave(Card card)
    {

    }

    public void removeToHand(Card card)
    {

    }

    public void removeToMonster(Card card)
    {

    }

    public void removeToSpell(Card card)
    {

    }

    public void removeToDeck(Card card)
    {

    }

    public boolean isRitualCardInHand()
    {

    }

    public boolean isSpellZoneFull()
    {
        return getPlayBoardByTurn().getSpellTrap().size() == 5;

    }

    public boolean wasSommoned(MonsterCard card)
    {

    }

    public boolean wasAttacked(Card card)
    {

    }

    public boolean wasChanged(Card Card)
    {

    }

    public Boolean isHandFull()
    {
        return getPlayBoardByTurn().getHand().size() == 6;

    }

    public boolean isMonsterZoneFull()
    {
        return getPlayBoardByTurn().getMonsters().size() == 5;

    }


}
