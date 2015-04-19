
    // You create an inventory for the player as so:
    MenuController.getManager().createMenu(player "menu title");




    // You can get an inventory menu for the player as so:
    InventoryMenu menu = MenuController.getManager().getMenu(player);




    // You can then use the menu's sub commands etc...
    // You can also add items to the menu like so:
    MenuItem i = new MenuItem(menu, "item name", itemstack);
    // NOTICE: you cannot create an instance of MenuItem
    //         instead you must create your own MenuItem
    //         object by extending MenuItem.
    //
    //         The only available MenuItem built into the
    //         API is the CommandableItem. This MenuItem
    //         object allows you to bind commands to an item.
    //
    //         Example:
    CommandableItem i = new CommandableItem(menu, "item name", itemstack, "say hello", "say welcome", "say bonjour" ...) // you can keep going
    // This item will trigger all 3 commands




    // you can remove an item from the menu by doing:
    i.setItem(null);




    // You can save items by doing
    MenuController.getLoader().save(i);




    // You can get the list of saved items by doing
    MenuController.getLoader().getLoadedItems();




    // You can the iterate through that list however you want,
    // you can technically use the "item name" provided in the constructor
    // as a key value.



    // If you do not want inventories to be stored within the manager
    // it is optional to create your own, However it should be noted
    // that you must handle the event registration yourself.
    // You should register the events upon InventoryMenu creation
    // and then you should use the "HandlerList.unregisterAll(InventoryMenu)"
    // to unregister the menu.
