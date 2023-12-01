function mostrarVentanaConfirmacion(){
    $('#modalConfirmacion').modal('show');
}
function agregarProductoAlCarrito(productoId){
    var cantidad = parseInt($('#cantidad').val());
    console.log("ID Producto y Cantidad:" + productoId +","+ cantidad);

    $.ajax({
        type: "POST",
        url: `/borabora/AgregarAlCarrito?id=${productoId}&cant=${cantidad}`,
        success: function(data) {
            if(data!=0){
                $("#cantidad").val(1);
                $("#prodsCarrito").text(data);
            }
            else{ alert("No hay stock suficiente para este producto."); }
            $("#modalConfirmacion").modal('hide');            
        },
        error: function() {
            alert('Error al agregar producto en el carrito.');
        }
    });
    setTimeout(function() {
        window.location.href = "/borabora/catalogo";
    }, 1500);
    
}

function modificarCantidad(productoId, tipo){
    var cantidadInput = $("#cant_prod_"+productoId);
    var cantidadActual = parseInt(cantidadInput.val());
    
    var PagoF = parseFloat($('#precioTotal').text().replace("Total: S/.",""));
    var PrecioP = parseFloat(carrito[productoId][1]);
    if (tipo == "mas") {
        cantidadInput.val(cantidadActual + 1);
        $('#precioTotal').text("Total: S/."+parseFloat(PagoF+PrecioP).toFixed(1)+"0");
    } else {
        if ((cantidadActual - 1)>-1){
            cantidadInput.val(cantidadActual - 1);
            $('#precioTotal').text("Total: S/."+parseFloat(PagoF-PrecioP).toFixed(1)+"0");
        }
    }
    carrito[productoId][0] = parseFloat(cantidadInput.val());
}
var carrito = {};
function mostrarInfoCarrito(carritoId){
    $.ajax({
        url: '/borabora/MostrarCarrito',
        data: { carrito:carritoId },
        success: function(data) {
            var listItems = ""; var sumaT=0; carrito = {};
            if(Object.entries(data).length != 0){
                for (var [productoId, ProductoCarrito] of Object.entries(data)) {
                    listItems += `<li class="list-group-item d-flex justify-content-between align-items-center" id="productoItemCarrito_${productoId}">
                                        <div class="col-5"><h6>${ProductoCarrito[0]}</h6></div>
                                        <div class="input-group input-group-sm mb-3 row col">
                                            <div class="col-3"></div>
                                            <button onclick="modificarCantidad(${productoId},'menos')" class="col-2 btn btn-outline-secondary btn-sm">-</button>
                                            <input type="text" id="cant_prod_${productoId}" class="form-control col-4" value="${ProductoCarrito[1]}" readonly>
                                            <button onclick="modificarCantidad(${productoId},'mas')" class="col-2 btn btn-outline-secondary btn-sm mr-2">+</button>
                                            <button onclick="eliminarProducto(${productoId})" class="col-2 btn btn-danger btn-sm">X</button>
                                        </div>
                                </li>`;
                    sumaT+= ProductoCarrito[1] * ProductoCarrito[2];
                    carrito[productoId] = [ProductoCarrito[1], ProductoCarrito[2]];
                }
                $('#precioTotal').text("Total: S/."+sumaT.toFixed(1)+"0");
                $('#modalCarrito ul').html(listItems);
                $('#modalCarrito').modal('show');
            }else{
                alert("No hay productos en el carrito.");
            }
            
        },
        error: function() {
            alert('Error al obtener la información del carrito.');
          }
    });
}

function actualizarNumeroProductos(nuevoNumero) {
    $('#nProductos').text(nuevoNumero);
}

function recalcularTotal() {
    var sumaT = 0;
    for (var [productoId, valores] of Object.entries(carrito)) {
        sumaT += valores[0] * valores[1];
    }
    $('#precioTotal').text("Total: S/." + sumaT.toFixed(1) + "0");
}

function actualizarInfoCarrito(){
    if (Object.keys(carrito).length != 0 ){
        Object.values(carrito).forEach(valores => valores.forEach((v,i,a) => a[i] = parseFloat(v)));
        $.ajax({
            type: "POST",
            url: "/borabora/ActualizarCarrito",
            data: JSON.stringify(carrito),
            contentType: "application/json",
            success: function(response) {
                $("#modalCarrito").modal('hide');
                $("#prodsCarrito").text(response);
            },
            error: function(error) {
                alert('Error al actualizar la información del carrito.');
              }
        });
    }
}

function eliminarProducto(productoId) {
    if (confirm("¿Estás seguro de eliminar este producto del carrito?")) {
        $.ajax({
            type: "POST",
            url: "/borabora/EliminarDelCarrito",
            data: {id : productoId},
            success: function(response) {
                $("#productoItemCarrito_"+productoId).remove();
                
                $("#prodsCarrito").text(response);
                if (response==0) { 
                    setTimeout(function() { $("#modalCarrito").modal('hide'); }, 1500);
                }
            },
            error: function() {
                alert("Error al eliminar el producto del carrito.");
            }
        });
    }
}