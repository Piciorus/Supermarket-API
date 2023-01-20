package application.Domain.Models.ShoppingList.Request;

public class AddProductToShoppingListRequest {
    private Long productId;
    private Long shoppingListId;

    public AddProductToShoppingListRequest(Long productId, Long shoppingListId) {
        this.productId = productId;
        this.shoppingListId = shoppingListId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(Long shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

}
