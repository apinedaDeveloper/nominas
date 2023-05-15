jQuery(function($){
    
    $("a[rel^='prettyPhoto']").prettyPhoto({
			animationSpeed: 'normal', /* fast/slow/normal */
			opacity: 0.80, /* Value between 0 and 1 */
			showTitle: true, /* true/false */
                        modal: true,
                        social_tools:false,
                        default_width: 750,
			default_height: 650
		});       
});


   
function verDialog(idReporte,pNomGest)
{

$.prettyPhoto.open('../verreportepdf?id='+idReporte+String.fromCharCode(38)+'rep=REVERGEST'+String.fromCharCode(38)+'id2='+pNomGest+'?iframe=true','DETALLE DE CAMBIOS',null);

return false;
}


function genReport(idReporte,pNomGest){ 

window.open("../verreportepdf?id="+idReporte+String.fromCharCode(38)+"rep=REVERGEST"+String.fromCharCode(38)+"id2="+pNomGest,"preview","width=640,height=640,scrollbars=YES,location=NO,directories=NO,resizable =1"); 

} 
