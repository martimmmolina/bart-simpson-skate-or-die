package org.academiadecodigo.rapunshells.game.gfx;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Control implements KeyboardHandler {

    private Screen screen;
    private boolean isDoneBefore = false;

    public Control(Screen screen) {
        this.screen = screen;
        keyboardInit();
    }

    private void keyboardInit() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent spaceKey = new KeyboardEvent();
        spaceKey.setKey(KeyboardEvent.KEY_SPACE);
        spaceKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spaceKey);

        KeyboardEvent rKey = new KeyboardEvent();
        rKey.setKey(KeyboardEvent.KEY_R);
        rKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rKey);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                if(!isDoneBefore) {
                    isDoneBefore = true;
                    screen.setStarted(true);
                }else {
                    screen.setRestarted(true);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
