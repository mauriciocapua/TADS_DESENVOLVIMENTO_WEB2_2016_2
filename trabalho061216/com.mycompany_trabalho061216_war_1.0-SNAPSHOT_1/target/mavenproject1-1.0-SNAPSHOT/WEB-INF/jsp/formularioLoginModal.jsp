<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Login</h4>
            </div>
            <div class="modal-body">
                <form action="/mavenproject1/atendente/efetuaLogin">
                    <div class="form-group">
                        <label for="login">Login:</label>                        
                        <input type="text" class="form-control" name="login" />
                    </div>
                    <div class="form-group">
                        <label for="password">Senha:</label>
                        <input type="password" class="form-control" name="senha">
                    </div>                    

                    <div class="modal-footer">
                        <button type="submit" class="btn btn-default">Enviar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
