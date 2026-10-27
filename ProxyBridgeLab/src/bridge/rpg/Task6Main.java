package bridge.rpg;

public class Task6Main {
    public static void main(String[] args) {
        Knight swordKnight = new Knight(new Sword());
        Knight wandKnight = new Knight(new MagicWand());

        swordKnight.attack();
        wandKnight.attack();
    }
}
