package Exercise.StateMachine;

enum State {
    SMALL,
    FIRE,
    CAPE,
    SUPER;
}

enum Event {
    ObtainMushRoom,
    ObtainCape,
    ObtainFireFlower,
    ObtainMonster;
}

public class MarioStateMachine {
    private State currentState = State.SMALL;

    public State getCurrentState() {
        return currentState;
    }

    public State triiger(Event event) {
        switch (event) {
            case ObtainCape:
                currentState = onEventObtainCape();
                break;
            case ObtainMonster:
                // 同上
                break;

        }

        return currentState;
    }

    private State onEventObtainCape() {
        // if 条件判断
        if (currentState == State.FIRE) {
            return State.SMALL;
        }

        return currentState;
    }

    public static void main(String[] args) {
        MarioStateMachine marioStateMachine = new MarioStateMachine();

        System.out.println(marioStateMachine.triiger(Event.ObtainCape));
    }
}
