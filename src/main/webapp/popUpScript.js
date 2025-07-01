/**
 * 
 */
function addItemToCart(itemId, quantity) {
    const formData = new FormData();
    formData.append("action", "add");
    formData.append("itemId", itemId);
    formData.append("quantity", quantity);

    fetch("CartServlet", {
        method: "POST",
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        if (data.conflict) {
            if (confirm("Items from another restaurant are already in the cart. Do you want to replace them?")) {
                // User chose to replace the cart items
                fetch("CartServlet", {
                    method: "POST",
                    body: new URLSearchParams({
                        action: "clearCart" // Add logic in servlet to clear the cart
                    })
                })
                .then(() => {
                    // Retry adding the item
                    addItemToCart(itemId, quantity);
                });
            } else {
                alert("The item was not added to the cart.");
            }
        } else {
            // Success message or reload the page to reflect the cart changes
            window.location.href = "cart.jsp";
        }
    });
}
