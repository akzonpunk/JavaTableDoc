<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src='/webjars/AdminLTE/2.4.2/bower_components/jquery/dist/jquery.min.js'></script>
<link rel="stylesheet" href="/resources/css/jquery.dataTables.min.css">
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <section class="content-header">

    </section>    
    <section class="content">
        
      <div class="box">
          <div class="box-body">
            <form action="${pageContext.request.contextPath}/buscarDoc" method="POST">

            <div class="form-group">
                <label class="col-sm-2 control-label">Codigo/Descripcion:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control"  id="dato" name="dato"/>                     
                </div>                
                <div class="col-sm-1">
                    <input type="submit" value="Buscar" class="btn btn-primary"/>
                </div>
                <div class="col-sm-1">
                    <c:if test="${empty ListaDocumento}">
                    <a class="btn btn-info" href="${pageContext.request.contextPath}/formDocumento">Nuevo Documento</a>
                    </c:if>
                </div>
            </div>
              </form>
          </div>
          </div> 
                
                
                
    <c:if test="${!empty ListaDocumento}">
        <div class="box">
                <div class="box-header">
                    <h3 class="box-title">Reporte de Documentos</h3>                                    
                </div><!-- /.box-header -->        
        <div class="box-body table-responsive">
        <table id="example1" class="table table-bordered table-striped">
          <thead >
            <tr>
              <th >#</th>
              <th >Codigo</th>
              <th >Descripcion</th>
              <th >Estado</th>
              <th >Opciones</th>
            </tr>
          </thead>
          <tbody>
                <c:forEach items="${ListaDocumento}" var="dato">
                      <tr>
                        <th >1</th>
                        <td>${dato.codigo}</td>
                        <td>${dato.descripcion}</td>
                        <td>${dato.estado}</td>
                        <td align="center">
                            <a href="${pageContext.request.contextPath}/elimDoc?id=${dato.idDocumento}" ><span title="Eliminar" class="glyphicon glyphicon-remove"></span></a>
                            <a href="${pageContext.request.contextPath}/formModif2Documento?id=${dato.idDocumento}" ><span title="Editar" class="glyphicon glyphicon-edit"></span></a>
                        
                        </td>
                      </tr>
              </c:forEach> 
            </tbody>
            <tfoot>
                <tr>
                <th >#</th>
                <th >Codigo</th>
                <th >Descripcion</th>
                <th >Estado</th>
                <th >Opciones</th>
                </tr>
            </tfoot>            
          </table>  
          </div>
        </div>                                
          </c:if>         
        
    </section>

</div>
<script>
  $(function () {
    $('#example1').DataTable();
//    $('#example2').DataTable({
//      'paging'      : true,
//      'lengthChange': true,
//      'searching'   : true,
//      'ordering'    : true,
//      'info'        : true,
//      'autoWidth'   : false
//    });
  });
</script>