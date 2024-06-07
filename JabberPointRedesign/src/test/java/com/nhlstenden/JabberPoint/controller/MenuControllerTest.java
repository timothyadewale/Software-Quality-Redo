package com.nhlstenden.JabberPoint.controller;

import com.nhlstenden.JabberPoint.model.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MenuControllerTest {
    private Presentation presentation;
    private Frame frame;
    private MenuController menuController;

    @BeforeEach
    void setUp() {
        presentation = new Presentation(); // Use a real instance instead of a mock
        frame = new Frame();
        menuController = new MenuController(frame, presentation);
    }

    @Test
    void testOpenPresentation() {
        Menu fileMenu = getMenu(MenuController.FILE);
        MenuItem openItem = getMenuItem(fileMenu, MenuController.OPEN);
        assertNotNull(openItem);

        // Simulate open action
        openItem.getActionListeners()[0].actionPerformed(new ActionEvent(openItem, ActionEvent.ACTION_PERFORMED, null));
        // Additional verification can be done here
    }

    @Test
    void testNewPresentation() {
        Menu fileMenu = getMenu(MenuController.FILE);
        MenuItem newItem = getMenuItem(fileMenu, MenuController.NEW);
        assertNotNull(newItem);

        // Simulate new action
        newItem.getActionListeners()[0].actionPerformed(new ActionEvent(newItem, ActionEvent.ACTION_PERFORMED, null));
        // Additional verification can be done here
    }

    @Test
    void testSavePresentation() {
        Menu fileMenu = getMenu(MenuController.FILE);
        MenuItem saveItem = getMenuItem(fileMenu, MenuController.SAVE);
        assertNotNull(saveItem);

        // Simulate save action
        saveItem.getActionListeners()[0].actionPerformed(new ActionEvent(saveItem, ActionEvent.ACTION_PERFORMED, null));
        // Additional verification can be done here
    }

    private Menu getMenu(String menuName) {
        for (int i = 0; i < menuController.getMenuCount(); i++) {
            Menu menu = menuController.getMenu(i);
            if (menu.getLabel().equals(menuName)) {
                return menu;
            }
        }
        return null;
    }

    private MenuItem getMenuItem(Menu menu, String itemName) {
        for (int i = 0; i < menu.getItemCount(); i++) {
            MenuItem item = menu.getItem(i);
            if (itemName.equals(item.getLabel())) {
                return item;
            }
        }
        return null;
    }
}
