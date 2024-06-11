gblActInterfaz=false;
gbl_form="";
gbl_actionId="";
gbl_Tipo="";

function boton_aceptar_click() {
    var lst = document.getElementById("inptObserv");
    var lista=document.getElementById('cmbEstado');
    var indice=lista.selectedIndex;
    if (indice>=0) {  
        var vval = lista.options[indice].value;
        var vTipo=document.getElementById("hdn_tipo");
        var vId=document.getElementById("hdn_Id");
        if (vval!="ER") {
            $.ajax( {
                url: "/Nomina/faces/servMant",
                type: "POST",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                data: "codop=1&var1="+vId.value+"&var2="+vval+"&var3="+vTipo.value+"&var4="+lst.value,
                processData: false,
                dataType:"json",
                success: function(data)
                {
                    if (data!=null && data.cod=="OK"){
                        gblActInterfaz=true; 
                        $("#lblResultado").attr("class","ui-state-highlight");
                        $("#lblResultado").html(data.msg + " Espere a que se refresque la página por favor.");
                        $("#cmbEstado").attr("disabled",true);  
                        $("#inptObserv").attr("disabled",true); 
                        $("button").attr("disabled", "disable");
                        $(this).dialog('close');
                        alert("¡¡Operación realizada exitósamente!!!");
                        //setTimeout(location.reload(),1000);
                        //location.reload(3000);
                        setTimeout(function(){location.reload(true);}, 2000);
                    } else { // error
                        $("#lblResultado").attr("class","ui-state-error");  
                        $("#lblResultado").html(data.msg);
                        //alert(data.smg);
                    }
                }
            });                                                      
        } else {
            $("#lblResultado").attr("class","ui-state-error");  
            $("#lblResultado").html("No existen estados válidos.");
            alert("No existen estados válidos.");
        }
    } else {
        $("#lblResultado").attr("class","ui-state-error");  
        $("#lblResultado").html("No existen estados válidos.");
        alert("No existen estados válidos.");
    }
}

function inicializarDialogo(){
    //// inicializando  el dialogo
    vinput=document.getElementById('dlg_Autorizacion');	
    var vIdGestion, vMensajeConfirmacion;
    $(vinput).dialog( {
        autoOpen: false,
	height: 350,
	width: 550,
	modal: true,
	buttons: 
	{
            'Salir': function() {
                $(this).dialog('close');
            } ,
            'Aceptar': function() {
                vIdGestion = document.getElementById("hdn_Id");
                vMensajeConfirmacion = "¿Desea aceptar la operación?";
                if ( vIdGestion != null){
                    vMensajeConfirmacion = "¿Desea aceptar la operación del ID " + vIdGestion.value + "?";    
                }
                if ( confirm(vMensajeConfirmacion) == true ) {
                    boton_aceptar_click();
                }
            }
	},
	close: function()
	{                    
            if (gblActInterfaz==true)
            {
                submitForm(gbl_form,1,{source:gbl_actionId});
                gblActInterfaz=false;
            }
        }
    });
}	

//---- para llamar al dialogo para que muestre las opciones	
function OpenDialogo(opcion){  
    if ($('#dlg_Autorizacion').dialog( "option", "modal" )!=true){
        inicializarDialogo();
    }
    if (opcion==1){
        $('#dlg_Autorizacion').dialog("option", "title", 'Dar visto bueno' );
    } else if (opcion==2){
        $('#dlg_Autorizacion').dialog("option", "title", 'Rechazar' );
    }  
    var vTipo=document.getElementById("hdn_tipo");
    var vId=document.getElementById("hdn_Id");
    borrarElementosCombo("cmbEstado");
    $("#cmbEstado").attr("disabled",false);  
    $("#inptObserv").attr("disabled",false); 
    $("#inptObserv").val("");                                 
    if (vId.value!=null && vId.value!="" ){
        $.getJSON("/Nomina/faces/consuljson?codop=2&var1="+opcion+"&var2="+vTipo.value+"&var3="+vId.value+"&var4="+new Date().getMilliseconds(), function(json){ 
            if (json!=null) {  
                if (json.length>0) {       
                    for(var i=0; i < json.length; i++) { 	           
                        var newOption = new Option(json[i].nom,json[i].id);
                        var lst = document.getElementById("cmbEstado");
                        if (lst) lst.options[i] = newOption;             
                    }
                } else {
                    var newOption = new Option("No hay opciones disponibles","ER");
                    var lst = document.getElementById("cmbEstado");
                    if (lst) lst.options[0] = newOption;
                }
            } else {
            }
        });
    } else {
        var newOption = new Option("No hay opciones disponibles","ER");
        var lst = document.getElementById("cmbEstado");
        if (lst) lst.options[0] = newOption;
    }
    $("#lblResultado").attr("class","");  
    $("#lblResultado").html(" ");
    $("#inptObserv").html(" ");
    $('#dlg_Autorizacion').dialog('open');
    return false;
}

function borrarElementosCombo(pIdCombo) {
    var lst = document.getElementById(pIdCombo);
    for (var i=0;i<lst.options.length;i++)  {
        lst.options[i] = null ;
    }
}

/*funcion que se implemento para validar que los complementos a trasladar tenga descuento igss*/
function validaComplemento(){
    
    var vIdComplemento=document.getElementById("hdn_Id").value;
    
    $.getJSON("/Nomina/faces/consuljson?codop=6&var1="+vIdComplemento, function(json){
        if (json!=null){  
            if (json.length>0){                
                var respuesta = json[0].respuesta;
                if(respuesta=='CORRECTO'){
                    
                    return OpenDialogo(1);
                }
                else{
                    alert(respuesta);
                }
            }
            else{
                alert('Hubo un error, contacte al administrador del sistema');
            }
        }
        
    });
    return false;
    
}

function validaBonoProcNomina(idProceso){
    var res = "";
    $.getJSON("/Nomina/faces/consuljson?codop=8&var1="+idProceso, function(json){
        if (json!=null){  
            if (json.length>0){                
                res = json[0].respuesta;    
                //alert(res);
            }
            else{
                res='Hubo un error, contacte al administrador del sistema';
            }
        }
        
    });
    return setTimeout(res, 5000);
    //setTimeout(alert('aaaa '+res), 3000);
}


function validaReintegro(){
    
    var vIdReintegro=document.getElementById("hdn_Id").value;
    
    $.getJSON("/Nomina/faces/consuljson?codop=10&var1="+vIdReintegro, function(json){
        if (json!=null){  
            if (json.length>0){                
                var respuesta = json[0].respuesta;
                if(respuesta=='CORRECTO'){
                    
                    return OpenDialogo(1);
                }
                else{
                    alert(respuesta);
                }
            }
            else{
                alert('Hubo un error, contacte al administrador del sistema');
            }
        }
        
    });
    return false;
    
}