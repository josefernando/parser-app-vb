package br.com.arcatalog.parser.app.vb6;

import br.com.arcatalog.model.vb6.Inventory;
import br.com.arcatalog.model.vb6.InventoryItem;
import br.com.arcatalog.parser.vb6.Vb6BaseListener;
import br.com.arcatalog.parser.vb6.Vb6Parser;

public class ParserInventory extends Vb6BaseListener {
	
	Inventory inventory;
	
	final String GUI_DEFINITION = "GUI_DEFINITION";
	final String NAME = "NAME";
	final String VB_FORM = "VB.FORM";
	
	public  ParserInventory()  {
		 inventory = new Inventory();
	}
	
	/*
	 * Fim dos eventos
	 */
	@Override 
	public void enterStartRule(Vb6Parser.StartRuleContext ctx) {
	}
	
	@Override 
	public void exitStartRule(Vb6Parser.StartRuleContext ctx) {
		System.out.println("INVENTORY");
		System.out.println("---------");
		System.out.println(inventory.toString());
	}

	public void enterGuiDefinition(Vb6Parser.GuiDefinitionContext ctx) {
		InventoryItem inventoryItem = new InventoryItem();
		 inventoryItem.setType(GUI_DEFINITION);
		 inventory.addItem(inventoryItem);
		 inventoryItem.addProperty("TYPE", ctx.type().getText());
		 
		 if(ctx.type().getText().equalsIgnoreCase(VB_FORM)) {
			 inventory.setType(ctx.type().getText());
			 inventory.setName(ctx.Name.getText());
		 }
		 inventoryItem.setName(ctx.Name.getText());

		 inventoryItem.addProperty(NAME, ctx.Name.getText());
	}
}