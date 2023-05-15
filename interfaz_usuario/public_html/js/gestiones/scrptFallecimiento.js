$(document).ajaxStart(function(){ 
    $('#ajaxBusy').show(); 
}).ajaxStop(function(){ 
    $('#ajaxBusy').fadeOut(700,function(){$('#ajaxBusy').hide();});
});

function trimStrings(stringToTrim) {
    return stringToTrim.replace(/^\s+|\s+$/g,"");
}

function checkCuenta(numCuenta, cui) {
    var vLblExito, vLblError, vInptHiddenEstadoCta, vSelectOneTipoPago;
    var vInptTextNumCta, vCmdBtnValidarCta, vMensaje; 
    vLblExito = document.getElementById('page1:lblExitoValidarCta');
    vLblError = document.getElementById('page1:lblErrorValidarCta');
    vInptHiddenEstadoCta = document.getElementById('page1:inptHiddenEstadoCta');
    vInptHiddenEstadoCta.value=false; //valor inicial
    //vSelectOneTipoPago = document.getElementById('page1:selectOneChoice_tipoPago');
    vInptTextNumCta = document.getElementById('page1:inptText_numCuenta');
    //vCmdBtnValidarCta = document.getElementById('page1:cmdBtn_validarCuenta');
    $(vLblExito).hide();
    $(vLblError).hide();
    $.getJSON("/Nomina/faces/consuljson?codop=4"+String.fromCharCode(38)+"var1="+numCuenta+"&var2=0&var3="+cui+"&var4="+new Date().getMilliseconds(), function(json) {
        if (json.resul!=null){
            if (json.resul=='ok'){
                vMensaje = json.msg + "<br/> DPI(CUI): " + cui + "<br/>" + "No. cuenta:" + numCuenta;
                vInptHiddenEstadoCta.value=true;
                $(vLblExito).html(vMensaje);
                $(vLblExito).show();
                //$(vInptTextNumCta).attr("disabled",true);
                //$(this).attr("disabled",true);
                //vInptTextNumCta.disabled=true;
                //vSelectOneTipoPago.readOnly = true;
                vInptTextNumCta.readOnly = true;
            } else {
                $(vLblError).html(json.msg);
                $(vLblError).show();
            }
        } else {
            alert("Hubo un error al intentar comunicación con el web services del banco. Intente de Nuevo por favor.");
        }
    });
    return false;
}