$(document).ajaxStart(function(){ 
	$('#ajaxBusy').show(); 
}).ajaxStop(function(){ 
                
        $('#ajaxBusy').fadeOut(700,function(){$('#ajaxBusy').hide();});
});



function trimStrings(stringToTrim) {
	return stringToTrim.replace(/^\s+|\s+$/g,"");
}

function checkCuenta()
{
           var vNombreCompleto;
           vvar1=document.getElementById('form1:page1:inpt_cuenta'); 
           vvar2=document.getElementById('form1:page1:hdn_cuenta'); 
           vCuentaA=document.getElementById('form1:page1:inptCuentaA');
          
           vvar2.value=vvar1.value;         
          
           vAviso=document.getElementById('form1:page1:divAviso');
           vError=document.getElementById('form1:page1:lblNomReg')
           vError2=document.getElementById('form1:page1:lblNomRegEr')
           vOrdenCed=document.getElementById('form1:page1:inpthdnOrdenCedula');
           vDPI=document.getElementById('form1:page1:inpt_cui');
           vRegCed=document.getElementById('form1:page1:inpt_registrocedula')
           vStatus=document.getElementById('form1:page1:inpthdnStatusCnt');
           vComando=document.getElementById('form1:page1:cmd_cambiar');
           
          
            
           if (vCuentaA.value!=null){
            if (vCuentaA.value==trimStrings(vvar1.value)){
            
             alert ("Por Favor ingrese otro No. Cuenta, no puede ser igual al actual");
             return false;
            }
            
           }
           
            vvar1.disabled=true; 
            
           /*
           vInputNombre=document.getElementById('form1:page1:inpt_nombre1');
           vNombreCompleto=trimStrings(vInputNombre.value);
           
           vInputNombre=document.getElementById('form1:page1:inpt_nombre2');
           vNombreCompleto=vNombreCompleto+" "+trimStrings(vInputNombre.value);
           
           vInputNombre=document.getElementById('form1:page1:inpt_apellido1');
           vNombreCompleto=vNombreCompleto+" "+trimStrings(vInputNombre.value);
           
           vInputNombre=document.getElementById('form1:page1:inpt_apellido2');
           vNombreCompleto=vNombreCompleto+" "+trimStrings(vInputNombre.value);
           
           */
           
          
          $(vAviso).hide(); 
          $(vError).hide();
          $(vError2).hide();
          
          
          $.getJSON("/Nomina/faces/consuljson?codop=4"+String.fromCharCode(38)+"var1="+vvar1.value+"&var2="+vOrdenCed.value+" "+vRegCed.value+ "&var3="+vDPI.value+"&var4="+new Date().getMilliseconds(), function(json)
          {
          
                   if (json.resul!=null){
                   
                       vLabel=document.getElementById('form1:page1:lblNomReg');     
                       vNombreCuenta=document.getElementById('form1:page1:inpthdnNomCuenta');     
                       
                       
                       
                       
                    
                       
                    if (json.resul=='ok'){
                       if (vRegCed.value!=null && vRegCed.value!="")
                        var vMensaje=json.msg+ "<br/> Nombre:"+vNombreCuenta.value+ "<br/> Cédula: "+vOrdenCed.value+" "+vRegCed.value+"<br/>"+"No. cuenta:" + vvar1.value;
                    
                       if (vDPI.value!=null && vDPI.value!="")
                        var vMensaje=json.msg+ "<br/> Nombre:"+vNombreCuenta.value+ "<br/> DPI(CUI): "+vDPI.value+"<br/>"+"No. cuenta:" + vvar1.value;
                    
                        $(vLabel).html(vMensaje);
                        //vNombreCuenta.value=json.msg;
                        vStatus.value="1";
                        //vComando.disabled=true;
                        $(dvChkA).show();
                        $(vLabel).show(); 
                        $(vAviso).show(); 
                    }else
                    {
                        vStatus.value="";
                        $(vError2).html(json.msg);
                        $(vError2).show();
                        vvar1.disabled=false;
                    }
                   
                   
                   }else
                   {
                    vLabel=document.getElementById('form1:page1:lblNomReg');	         
                   $(vLabel).html(" ");
                    vvar1.disabled=false;
                   }
           });
 return false;
}
          

function cambiarCuenta()
{
submitForm('form1',1,{source:'form1:page1:cmd_cambiar'});
}


function verificaCheck(pCheck)
{

 if (pCheck.checked==true){
 
  $(dvcambiarC).show();
 
 }else
 {
 
  $(dvcambiarC).hide();
 
 }


}