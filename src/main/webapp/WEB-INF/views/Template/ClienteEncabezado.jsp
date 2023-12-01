<nav class="navbar navbar-expand-lg navbar-dark fixed-top" style="background-color: #f8f9fa">	
    <div class="container">    	
        <a class="navbar-brand text-dark" href="/borabora/catalogo" style="text-align: center; font-size: 1.6em">
            <img src="/borabora/images/icons/logo-banner.png" alt="Logo" style="height: 50px; margin-right: 10px;">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item">
					<div class="badge badge-dark badge-pill">
						<img src="/borabora/images/icons/carrito.png" alt="Carrito" class="img-fluid"  style="height: 2em">
						<span id="prodsCarrito" class="badge badge-light badge-pill">${nProductos}</span>
					</div>
	                
	            </li>	      	
				<li class="nav-item dropdown"><a
		          class="nav-link dropdown-toggle h5 text-dark" href="#"
		          id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
		          aria-haspopup="true" aria-expanded="false"> Usuario: ${nombre}</a>
		          	<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		          		<a class="dropdown-item h5" href="/borabora/catalogo">Catálogo de productos</a> 
						<a class="dropdown-item h5" href="#" onclick="mostrarInfoCarrito(${idCarrito})">Carrito</a> 
		        	</div>
		        </li>
		        <li class="nav-item">
	                <a class="btn btn-danger" href="/borabora/home" style="margin-left: 10px;">Cerrar sesión</a>
	            </li>
	      </ul>
	    </div>  
    </div>
</nav>

<div class="modal fade" id="modalCarrito" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Información del Carrito</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="align-items-center mb-2">
                    <ul class="list-group" id="carritoInfo"></ul>
                    <span class="badge badge-info float-right mt-2" id="precioTotal"></span>
                </div>
                <div class="mt-2 row">
                    <div class="col-2"></div>
                    <button class="col btn btn-sm btn-primary" onclick="actualizarInfoCarrito()">Guardar Cambios</button><br><br>
                    <button class="col btn btn-sm btn-success ml-2" type="button" onclick="location.href='/borabora/compra/procesar'">Realizar compra</button>
                    <div class="col-2"></div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>

<script src="/borabora/js/scriptCarrito.js" type="text/javascript"></script>

