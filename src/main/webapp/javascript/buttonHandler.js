
$(".addButton").click(addToCart, event);

function addToCart(event) {
    var id = event.target.id;
    $.post("/ajax/addtocart",{id: id},function (response) {
        alert(response);
    })
}

$(".removeButton").click(removeFromCart, event);

function removeFromCart(event) {
    var id = event.target.id;
    $.post("/ajax/remove", {id: id},function (id)
    {
        $("#"+id).remove();
    })
}