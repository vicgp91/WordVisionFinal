package pa.resilienciacomunitaria.org.worldvision;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;


public class TwoFragment extends Fragment {

    private ArrayList<PrimerosAuxilios> primerosAuxilios;
    private ListView listEmergencias;
    private EmergenciaAdapter adapter;
    private TextView tvNombreaux, tvTelefonoaux;
    private ArrayList<AtencionesEmergencias> emergenciasArrayList;
    View rootView;


    public TwoFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_two, container, false);

        primerosAuxilios = new ArrayList<PrimerosAuxilios>();
        rellenarArrayList();
        tvNombreaux = (TextView) rootView.findViewById(R.id.tvTituloAux);

        rootView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        adapter = new EmergenciaAdapter(this.getContext(), primerosAuxilios);

        listEmergencias = (ListView) rootView.findViewById(R.id.listaNumerosAux);
        listEmergencias.setAdapter(adapter);

        listEmergencias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                // dialog(contactos.get(position).getTelefono());
                // MostrarNota(position);
                Intent i = new Intent(rootView.getContext(), VerInfoPrimerosAuxilios.class);
                i.putExtra("titulo", primerosAuxilios.get(position).getNombre());
                i.putExtra("imagen", primerosAuxilios.get(position).getImagen());
                i.putExtra("contenido", primerosAuxilios.get(position).getDescripcion());
                i.putExtra("atencionesEmergencias", new Gson().toJson(primerosAuxilios.get(position).getEmergenciasArrayList()));


                //i.putExtra("atencionesEmergencias",primerosAuxilios.get(position).getEmergenciasArrayList() );
                startActivity(i);
            }
        });


        return rootView;
    }

    private void rellenarArrayList() {


        //---------------------Contenido Resiliencia------------------------------------------------------------------------------------
        String contenidoResiliencia1="<br><br><b>Objetivos de los Futuros preferidos 1.</b>" +
                "<br><br>El contexto en el nivel de la comunidad est&aacute fortalecido y estandarizado, y el programa de evaluaci&oacuten del riesgo desarrollado e incorporado en el IPM." +
                "Las plantillas de proyecto y las herramientas desarrolladas para la construcci&oacuten de intervenciones de desarrollo resiliente incorporados en las pol&iacuteticas de WV, sistemas y pr&aacutecticas, incluyendo IPM de Gu&iacutea de Orientaci&oacuten para el Programa Integrado." +
                "Mecanismos para el seguimiento de las vulnerabilidades, desarrollado y aplicado para medir la eficacia y adecuaci&oacuten de las intervenciones de desarrollo." +

                "<br><br><br><b>Objetivos de los Futuros preferidos 2.</b>" +
                "<br><br>Fortalecer los mecanismos de aprendizaje en la acci&oacuten, la investigaci&oacuten emp&iacuterica, documentaci&oacuten, an&aacutelisis y difusi&oacuten de las nuevas mejores pr&aacutecticas a nivel comunitario para aumentar la resiliencia, la" +
                "DDR y el cambio clim&aacutetico." +

                "<br><br>Comunidades de Pr&aacutectica movilizadas y activas en toda la organizaci&oacuten fomentando la innovaci&oacuten, el intercambio, el aprendizaje y la promoci&oacuten de CR / RRD y las mejoras pr&aacutecticas en materia de cambio clim&aacutetico." +
                "Adaptado del proyecto de Resiliencia Comunitaria" +
                "Establecer un sistema de seguimiento para la gesti&oacuten din&aacutemica de la informaci&oacuten y el contexto sobre el riesgo de desastres a nivel comunitario, nacional y regional para comprender mejor, mitigar el crecimiento de la vulnerabilidad y crisis pendientes." +
                "<br><br>Refuerzo de las capacidades y competencias en todos los niveles de construcci&oacuten de la resiliencia, la DRR y la adaptaci&oacuten al cambio clim&aacutetico." +

                "<br><br><br><b>Objetivos de los Futuros preferidos 3.</b>" +
                "<br><br>Asociaciones productivas y colaborativas en el lugar con organizaciones externas y coaliciones claves que aumenten la resiliencia centrada en las pr&aacutecticas de desarrollo a trav&eacutes de las industrias humanitarias y de desarrollo." +
                "<br><br>Abogar por y con los ni&ntildeos, el fortalecimiento de su participaci&oacuten en el proceso de la DDR y la promoci&oacuten de su papel como agentes de cambio." +
                "<br><br>Asociaciones de en el lugar con las principales instituciones acad&eacutemicas para fortalecer nuestra capacidad de investigaci&oacuten y recopilaci&oacuten de pruebas." +
                "<br><br><hr>";

        String contenidoResiliencia2="<br><br>Seg&uacuten la comunidad de Pr&aacutectica de Visi&oacuten Mundial (VM), Resiliencia Comunitaria es la capacidad que tiene una comunidad para:" +

                "<br>&#8226; Amortiguar el estr&eacutes o las fuerzas destructivas a trav&eacutes de la resistencia o adaptaci&oacuten." +
                "<br>&#8226; Manejar o mantener las funciones y las estructuras b&aacutesicas durante el impacto o el desastre." +
                "<br>&#8226; Recuperarse despu&eacutes del impacto o desastre." +

                "<br><br>Visi&oacuten Mundial busca alcanzar la Resiliencia Comunitaria posicion&aacutendola como uno de los seis objetivos fundamentales de su trabajo. Este objetivo espec&iacuteficamente plantea apoyar a las comunidades para contrarrestar los riesgos, mitigar los impactos, y disminuir las vulnerabilidades y la injusticia que ellas y sus ni&ntildeos y ni&ntildeas enfrentan." +
                "<br><br>Uno de los indicadores de Desarrollo" +
                "<br><br>Transformador (IDTs) de Visi&oacuten Mundial pretende medir la resiliencia de hogar. La del hogar es una estrategia de supervivencia adaptativa, tal y como lo es la venta de un recurso productivo para mitigar los impactos externos y/o factores de estr&eacutes ambiental con el fin de suplir las necesidades b&aacutesicas del hogar." +

                "<h2>&iquest;Por qu&eacute es importante la Resiliencia Comunitaria?</h2>" +
                "<br>Cada d&oacutelar invertido en la reducci&oacuten de riesgos de desastres (RRD) es el equivalente de entre cinco a diez d&oacutelares en la respuesta a un desastre." +
                "<br><br>La fatiga institucional est&aacute sobrecargada a las agencias humanitarias internacionales que responden a los desastres naturales y humanos. Se requiere una mayor atenci&oacuten en iniciativas de reducci&oacuten del riesgo para aliviar esta carga." +
                "Invertir en la reducci&oacuten de riesgos de desastres contribuye directamente al &eacutexito de los Objetivos de Desarrollo del Milenio" +
                "(ODM)." +
                "<br><br>Se anticipa que los desastres de arremetida lenta, provocados por la inseguridad alimentaria y los cambios clim&aacuteticos, aumentaran en los pr&oacuteximos a&ntildeos lo cual tiene una alta probabilidad de contribuir significativamente a la inestabilidad de las comunidades que viven bajo la l&iacutenea de la pobreza." +

                "<br><br><b><h2>&iquest;Cu&aacutendo se aplica la Resiliencia Comunitaria?</h2></b>" +
                "<br><b>Antes: </b>" +
                "<br>Para evitar el impacto, el estr&eacutes o el desastre completo (prevenci&oacuten o resiliencia)." +
                "<br><br><b>Durante: </b>" +
                "<br>Para resistir a el efecto de un impacto, estr&eacutes o desastre (absorci&oacuten o repuesta adaptiva)." +
                "<br><br><b>Despu&eacutes: </b>" +
                "<br>Para recuperar r&aacutepidamente de un impacto, un factor de estr&eacutes o desastre (la habilidad de recuperarse o repeler).<br><br><hr>";

        String contenidoResiliencia3="<br><br>Seg&uacuten el Modelo de Programas Integrales (IPM), la resiliencia se aplica a los pa&iacuteses del Contexto I (alto nivel de necesidades / bajo nivel de estabilidad) hasta los del Contexto V (nivel de necesidades relativamente bajo / al nivel de estabilidad econ&oacutemica)." +
                "<br><br><b><h2>&iquest;A qui&eacutenes se enfoca la resiliencia comunitaria en la regi&oacuten de Am&eacuterica Latina y el Caribe?</h2></b>" +
                "<br>Una red regional de 5.8 millones de ni&ntildeas, ni&ntildeos, adolescentes y j&oacutevenes y sus comunidades." +

                "<br><br><b><h2>&iquest;Qui&eacuten? = Pr&aacutecticas en Desarrollo Resiliente</h2></b>" +
                "<br><b>Meta del Proyecto: </b>Apoyar el bienestar sostenido de los ni&ntildeos, ni&ntildeas, adolescentes, j&oacutevenes y sus comunidades a trav&eacutes de transversalizar y engrandecer al escala de PDR como una parte integral de programaci&oacuten de desarrollo en la Regi&oacuten de Am&eacuterica Latina y el Caribe." +
                "<br><br><b>Futuros preferidos 1.</b>" +
                "<br>La programaci&oacuten a nivel comunitario, nacional, regional y mundial se ver&aacute reforzada por los enfoques y estrategias de adaptaci&oacuten que reducen eficazmente el riesgo de desastres y los impactos del cambio clim&aacutetico y construir comunidades resistentes, de manera que los beneficios del desarrollo se mantienen y se a&ntildeade a la forma sostenible para las generaciones futuras." +
                "<br><br><b>Futuros preferidos 2.</b>" +
                "<br>La capacidad de adaptaci&oacuten y sistemas de organizaci&oacuten se hacen operativos para proporcionar el desarrollo profesional y la pr&aacutectica del cambio estrat&eacutegico que sigue siendo sensible al ambiente externo." +
                "<br><br><b>Futuros preferidos 3.</b>" +
                "<br>Las alianzas estrat&eacutegicas est&aacuten en el lugar donde aumenten la resistencia de pr&aacutecticas de desarrollo a nivel mundial, y que influyen en la elaboraci&oacuten de pol&iacuteticas macro que proteger a las personas por lo que no est&aacuten en riesgo y se mueven las corrientes de caracter&iacutesticas innovadoras para crear un entorno propicio para efectivo y sostenibilidad de los beneficios del desarrollo." +

                "<br><br><b><h2>&iquest;C&oacutemo se aplica la Resiliencia Comunitaria por el PRC LACRO?</h2></b>" +
                "<br>Los capitales de medios de vida sostenible valorados son: Humano-cultural, f&iacutesico-infraestructura y espiritual- psicol&oacutegico. Los temas de Marco de Acci&oacuten Hyogo" +
                "(MAH) son: la gobernanza; la evaluaci&oacuten de riesgos, monitoreo y alerta; conocimiento y educaci&oacuten; factores de riesgo subyacentes; y preparaci&oacuten y respuesta a desastres. Los temas transversales claves en asoci&oacute con el MAH son: el g&eacutenero, protecci&oacuten de la ni&ntildeez, discapacidades," +
                "VIH/SIDA/Salud, y el apoyo voluntario." +
                "<br><br><b>An&aacutelisis del punto cr&iacutetico</b>" +
                "<br>Al utilizar el an&aacutelisis del &aacuterbol de problemas, las comunidades participantes toman en consideraci&oacuten siete &aacutereas tem&aacuteticas de vidas resilientes / medios de vida sostenible y cinco &aacutereas tem&aacuteticas del" +
                "Marco de Acci&oacuten de Hyogo (junto con los temas multidisciplinarios), para identificar la ra&iacutez de las causas primarias de vulnerabilidad y de amenazas en las comunidades que podr&iacutean llevarles a puntos cr&iacuteticos negativos y conversamente determinar las fuentes de factores protectivos que las llevaran a un punto cr&iacutetico positivo y la resiliencia.<br><br><hr>";

        ArrayList<Respuestas>  respuestaResiliencia = new ArrayList<Respuestas>();
        respuestaResiliencia.add(new Respuestas("Perdida de visión", false));
        respuestaResiliencia.add(new Respuestas("Dolor intenso en el área afectada", true));
        respuestaResiliencia.add(new Respuestas("Pérdida de audición", false));


        Preguntas preguntaResiliencia = new Preguntas("Síntomas de una fractura", respuestaResiliencia);

        ArrayList<AtencionesEmergencias>  resiliencia = new ArrayList<AtencionesEmergencias>();
        resiliencia.add(new AtencionesEmergencias(R.drawable.resiliencia, contenidoResiliencia1, "Descripción general", preguntaResiliencia));
        resiliencia.add(new AtencionesEmergencias(R.drawable.logo_nino, contenidoResiliencia2, "¿Qué es Resiliencia Comunitaria?", preguntaResiliencia));
        resiliencia.add(new AtencionesEmergencias(R.drawable.resiliencia3, contenidoResiliencia3, "¿Dónde se aplica?", preguntaResiliencia));


        //Primeros auxilios psicologicos.---------------------------------------------------------------------------

        String psicologico1="<br><br>Cuando las personas se enfrentan a  crisis severas derivadas de situaciones vinculadas a desastres naturales o " +
                "producidos por el hombre o ambos, se busca la manera de actuar y tomar mejores decisiones. " +
                "La Psicolog&iacutea de la Emergencia adem&aacutes de auxiliar y guiar a los involucrados para aliviar su sufrimiento procura sobre todo la " +
                "supervivencia y la disminuci&oacuten  m&aacutexima de los da&ntilde;os." +

                "<br><br><b>&iquest;C&oacutemo afectan las situaciones de crisis a las personas?</b><br>" +
                "&#8226; La naturaleza y gravedad del /  de los acontecimientos que experimentan.<br>" +
                "&#8226; Su experiencia con acontecimientos angustiantes anteriores.<br>" +
                "&#8226; El apoyo de otras personas en su vida.<br>" +
                "&#8226; Su historia personal y familiar de  problemas de salud mental.<br>" +
                "&#8226; Su cultura y tradiciones.<br>" +
                "&#8226; Su edad(por ejemplo, los ni&ntildeos de diferentes edades reaccionan de distintas maneras.)<br>" +

                "<br><br><b>&iquest;Qu&eacute es la primera ayuda psicol&oacutegica?</b><br>" +
                "Seg&uacuten ESFERA (2011) y IASC (2007), la primera ayuda psicol&oacutegica (PAP) describe una respuesta humana, de apoyo a otros " +
                "seres humanos que est&aacuten sufriendo y que pueden necesitar ayuda. " +
                "<br><br><b>La PAP trata los siguientes temas: </b><br>" +
                "&#8226; Brindar ayuda y apoyo pr&aacutectico de manera no invasiva <br>" +
                "&#8226; Evaluar las necesidades y preocupaciones.<br>" +
                "&#8226; Ayuda a las personas a atender sus necesidades b&aacutesicas.<br>" +
                "&#8226; Escuchar a las personas, pero no presionarlas para que hablen<br>" +
                "&#8226; Reconfortar a las personas y ayudarlas a sentirse calmadas.<br><br><hr>";

        String psicologico2="<br><br><b>&iquest;Qui&eacuten, Cu&aacutendo y D&oacutende?</b><br>" +
                "La PAP est&aacute dirigido a personas angustiadas afectadas recientemente por un acontecimiento cr&iacutetico grave. " +
                "Se puede proporcionar ayuda tanto a ni&ntildeos como a adultos. Sin embargo, no todos los que experimentan una situaci&oacuten de crisis " +
                "necesitar&aacuten o querr&aacuten PAP. No se debe forzar la ayuda en aquellos que no la quieren, sino estar disponible para aquellos que puedan desear apoyo." +

                "<br><br><b>Personas que necesitan mayor apoyo experto inmediato: </b><br>" +
                "&#8226; Personas con lesiones graves que ponen en riesgo la vida y que necesitan atenci&oacuten m&eacutedica urgente.<br>" +
                "&#8226; Personas que est&aacuten alteradas que no pueden ocuparse de s&iacute mismas o de sus hijos.<br>" +
                "&#8226; Personas que pueden hacerse da&ntildeos a s&iacute mismas o a otros." +

                "<br><br><b>&iquest;Cu&aacutendo se proporciona la primera ayuda psicol&oacutegica?</b><br>" +
                "&#8226; Puede facilitar PAP tan pronto como establezca contacto con personas que est&aacuten en situaciones de angustia.<br>" +
                "&#8226; Normalmente  esto ser&aacute durante o inmediatamente despu&eacutes del acontecimiento. Sin embargo, a veces puede ser d&iacuteas o semanas despu&eacutes " +
                "del acontecimiento dependiendo de cu&aacutento ha durado o grave ha sido el acontecimiento." +

                "<br><br><b>&iquest;D&oacutende se puede proporcionar primera ayuda psicol&oacutegica?</b><br>" +
                "Lo ideal ser&iacutea proporcionar PAP en un lugar donde exista cierta privacidad para hablar con la persona cuando se considere oportuno. " +
                "Para personas expuestas a ciertos tipos de acontecimiento cr&iacuteticos, como violencia sexual, la privacidad es esencial para la  confidencialidad " +
                "y el respeto de la dignidad de la persona.<br><br><hr>";

        String psicologico3="<br><br><b>La ayuda responsable requiere cuatro aspectos principales:</b><br> " +
                "&#8226; Respetar la seguridad, la dignidad y los derechos.<br>" +
                "&#8226; Adaptar la propia acci&oacuten a la cultura de las personas.<br>" +
                "&#8226; Considerar otras medidas de respuesta a la emergencia.<br>" +
                "&#8226; Cuidarse a uno mismo." +

                "<br><br><b>&iquest;Qu&eacute hacer?</b><br>" +
                "&#8226; Sea honrado y digno de confianza.<br>" +
                "&#8226; Respete el derecho de la gente a tomar sus propias decisiones.<br>" +
                "&#8226; Sea consciente  de sus propios prejuicios preferencias, y mant&eacutengalos al margen.<br>" +
                "&#8226; Deje claro a la gente que incluso si rechazan la ayuda ahora, podr&aacute recibirla en el futuro.<br>" +
                "&#8226; Respete la privacidad y mantenga la historia de la persona confidencial, salvo imperativos.<br>" +
                "&#8226; Comp&oacutertese de forma adecuada teniendo en cuenta la cultura, edad y g&eacutenero de la persona" +

                "<br><br><b>&iquest;Qu&eacute no hacer?</b><br>" +
                "&#8226; No se aproveche de su relaci&oacuten que ayuda.<br>" +
                "&#8226; No pida a la persona dinero o favores a cambio de ayudarle.<br>" +
                "&#8226; No haga falsas promesas o provea informaci&oacuten no contrastada.<br>" +
                "&#8226; No exagere sus habilidades.<br>" +
                "&#8226; No fuerce ayuda en la gente, y no sea entrometido o prepotente.<br>" +
                "&#8226; No presione a la gente para que le cuente su historia.<br>" +
                "&#8226; No comparta la historia de una persona con otras personas.<br>" +
                "&#8226; No juzgue a la persona por sus acciones o sentimiento." +

                "<br><br><b>Siempre que sea posible en respuesta a una situaci&oacuten de crisis: </b><br>" +
                "&#8226; Siga las indicaciones de las autoridades competentes a cargo de la gesti&oacuten de la crisis.<br>" +
                "&#8226; Inf&oacutermese de las respuestas de emergencia  que est&aacuten organizando, y de los recursos disponibles" +
                "si existieran para ayudar a las personas.<br>" +
                "&#8226; No estorbe al personal de b&uacutesqueda y rescate o al personal m&eacutedico de emergencia.<br>" +
                "&#8226; Sea consciente  de su rol, y de los l&iacutemites de su rol.<br><br><hr>";

        String psicologico4="<br><b>Comunicaci&oacuten adecuada</b><br>" +
                "Mantener la calma y demostrar comprensi&oacuten puede ayudar a que las personas angustiadas se sientan m&aacutes seguras y  a salvo, comprendida, respetada y atendida de forma apropiada." +
                "<br><br><b>Lo que debemos hacer y decir: </b><br>" +
                "&#8226; D&eacute la informaci&oacuten de un modo en que la persona la pueda atender, es decir de formas simples.<br>" +
                "&#8226; H&aacutegale saber que comprende, c&oacutemo se sienten y que lamenta sus p&eacuterdidas y lo que les ha pasado, como haberse quedad sin hogar " +
                "o haber perdido un ser querido.<br>" +
                "&#8226; H&aacutegale saber que reconoce sus fortalezas y la manera en que est&aacuten ayudando a s&iacute mismos.<br>" +
                "&#8226; Deje espacios para el silencio.<br>" +

                "<br><b>Lo que NO debemos hacer y decir.</b>" +
                "<br>&#8226; No presione a la persona para que cuente su historia." +
                "<br>&#8226; No interrumpa ni apure a las personas mientras cuenta su historia (por ejemplo, no mire la hora, ni hable demasiado r&aacutepido)." +
                "<br>&#8226; No toque a la persona si no est&aacute seguro de que sea apropiado." +
                "<br>&#8226; No juzgue lo que hayan hecho o dejado de hacer ni sus sentimientos." +
                "<br>&#8226; No invente cosas que no sabe." +
                "<br>&#8226; No utilice expresiones demasiado t&eacutecnicas. " +
                "<br>&#8226; No cuente la historia de otra persona." +

                "<br><br><b>Antes de acudir al sitio de la crisis, informarse acerca de lo siguiente.</b>" +
                "<br>&#8226; La situaci&oacuten de crisis." +
                "<br>&#8226; Servicios y apoyo disponible." +
                "<br>&#8226; Cuestiones de seguridad" +

                "<br><br><b>Principios de actuaci&oacuten de la primera ayuda psicol&oacutegica.</b>" +
                "<br>Observar, Escuchar y conectar."+

                "<br><br><b>Brinde informaci&oacuten</b><br>" +
                "<br><b>Las personas afectadas por una situaci&oacuten de crisis querr&aacuten informaci&oacuten sobre:</b><br>" +
                "&#8226; Lo sucedido.<br>" +
                "&#8226; La situaci&oacuten de sus seres queridos y de otros que han sido afectados. <br>" +
                "&#8226; Su seguridad.<br>" +
                "&#8226; Sus derechos.<br>" +
                "&#8226; C&oacutemo acceder a los servicios y cosas en general que necesitan." +

                "<br><br><b>Crisis y espiritualidad</b>" +
                "<br>&#8226; Conozca y respete el trasfondo religioso de la persona." +
                "<br>&#8226; Preg&uacutentele qu&eacute le suele ayudar a sentirse mejor, animarle a que haga cosas que ayuden a sobrellevar la situaci&oacuten, incluidas pr&aacutecticas espirituales si la persona las menciona." +
                "<br>&#8226; Escuche respetuosamente y sin juzgar las creencias espirituales o las preguntas que la persona pueda hacerse." +

                "<br><br><b>Prep&aacuterese a ayudar</b><br>" +
                "&#8226; Inf&oacutermese sobre situaciones de crisis, y las funciones y responsabilidades de los diferentes tipos de personas que est&aacuten ofreciendo ayuda.<br>" +
                "&#8226; Tenga en cuenta su propia salud.<br>" +
                "&#8226; Decida sinceramente si est&aacute o no preparado para ayudar en esta situaci&oacuten determinada de crisis y en este momento concreto.<br><br><hr>";


        ArrayList<Respuestas>  respuestasPap = new ArrayList<Respuestas>();
        respuestasPap.add(new Respuestas("Juzgar a la persona por sus acciones o sentimiento.", false));
        respuestasPap.add(new Respuestas("Compartir la historia de una persona con otras personas.", false));
        respuestasPap.add(new Respuestas("Respetar el derecho de la gente a tomar sus propias desiciones.", true));


        Preguntas preguntaPap = new Preguntas("¿Qu&eacute hacer en una ayuda Psicol&oacutegica?", respuestasPap);

        ArrayList<AtencionesEmergencias>  ayudaPsicologica = new ArrayList<AtencionesEmergencias>();
        ayudaPsicologica.add(new AtencionesEmergencias(R.drawable.psicologico1,psicologico1, "Ayuda Psicológicas", preguntaPap));
        ayudaPsicologica.add(new AtencionesEmergencias(R.drawable.ayuda_psicologica2, psicologico2, "", preguntaPap));
        ayudaPsicologica.add(new AtencionesEmergencias(R.drawable.psicologico3, psicologico3, "", preguntaPap));
        ayudaPsicologica.add(new AtencionesEmergencias(R.drawable.ayuda_psicologica4, psicologico4, "Comunicación adecuada", preguntaPap));

        //-------------------------------------Manejo de emergencias-----------------------------------------------------------------

        String manejo1="<br><br>Es una herramienta de gesti&oacuten estandarizada para atender las demandas en situaciones de emergencias y/o de no emergencia.<br>" +
                "&#8226; Representa las mejores pr&aacutecticas en el tema y ha sido adoptada como el est&aacutendar para la gesti&oacuten de las emergencias en forma global." +

                "<br><br><b>&iquest;D&oacutende puedo aplicar?</b><br>" +
                "El sistema de manejo de emergencia busca que bomberos estructurales, forestales, aeron&aacuteuticos, polic&iacutea y otros grupos trabajen bajo un mismo sistema, empleando la misma terminolog&iacutea com&uacuten con una organizaci&oacuten definida y regida por procedimientos estandarizados. " +
                "En la medida en que las  instituciones aplican estos procedimientos estandarizados en la atenci&oacuten de incidentes cotidianos, peque&ntildeos y f&aacuteciles de solucionar; mejoran su preparaci&oacuten para trabajar con el sistema en incidentes de gran magnitud. " +
                "<br><br><b>El SCI  se puede aplicar en: </b><br>" +
                "&#8226; Derrumbes, explosiones, inundaciones, terremotos, huracanes, erupciones volc&aacutenicas y tornados.<br>" +
                "&#8226; Incendios forestales, estructurales, industriales y aeron&aacuteuticos.<br>" +
                "&#8226; Accidentes de transporte a&eacutereo, ferroviario, acu&aacutetico o terrestre.<br>" +
                "&#8226; Accidentes dom&eacutesticos, vehiculares e industriales.<br>" +
                "&#8226; Misiones de b&uacutesqueda y operaciones de rescate.<br>" +
                "&#8226; Incidentes con materiales peligrosos.<br>" +
                "&#8226; Respuesta a derrames de petr&oacuteleo.<br>" +
                "&#8226; Eventos planificados ejemplo: Desfiles, celebraciones, conciertos, plazas p&uacuteblicas.<br><br><hr>";


        String manejo2="<br><br><b>Principios del sistema de manejo de emergencias.</b><br>" +
                "El SCI se basa en principios que permiten asegurar el despliegue r&aacutepido, coordinado y efectivo de los recursos y minimizar la alteraci&oacuten de las pol&iacuteticas y procedimientos operativos propio de cada una de las instituciones que responden\n" +
                "<br><br><b>Esos principios son:</b><br>" +
                "&#8226; Terminolog&iacutea com&uacuten.<br>" +
                "&#8226; Alcance de control.<br>" +
                "&#8226; Organizaci&oacuten modular.<br>" +
                "&#8226; Comunicaciones integradas.<br>" +
                "&#8226; Consolidaci&oacuten de planes en un plan de acci&oacuten del incidente (PAI).<br>" +
                "&#8226; Unidad de mano.<br>" +
                "&#8226; Comando unificado. <br>" +
                "&#8226; Instalaciones con ubicaci&oacuten determinada y denominaci&oacuten precisa.<br>" +
                "&#8226; Manejo integral de los recursos.<br>" +

                "<br><br><b>Estructura y funciones del sistema</b><br>" +
                "Cuando en un sistema se necesita el esfuerzo de diferentes instituciones, cualquiera sea la magnitud o " +
                "complejidad del mismo o el n&uacutemero de instituciones participantes, se requiere un trabajo coordinado para " +
                "asegurar una respuesta efectiva mediante el uso eficiente y seguro de los recursos.<br><br><hr>";

        String manejo3="<br><br><b>El sistema de manejo de emergencias est&aacute basado en ocho (8) funciones:</b><br>" +
                "&#8226; Mando.<br>" +
                "&#8226; Planificaci&oacuten.<br>" +
                "&#8226; Operaciones.<br>" +
                "&#8226; Log&iacutestica.<br>" +
                "&#8226; Administraci&oacuten y finanzas.<br>" +
                "&#8226; Seguridad.<br>" +
                "&#8226; Informaci&oacuten p&uacuteblica.<br>" +
                "&#8226; Enlace." +

                "<br><br><b>Manejo por objetivos</b><br>" +
                "En el manejo de incidentes, los objetivos respecto a las siguientes prioridades: <br>" +
                "&#8226; Salvamento de vidas.<br>" +
                "&#8226; Estabilizaci&oacuten de incidentes.<br>" +
                "&#8226; Reservaci&oacuten de la prioridad. <br>" +

                "<br><br><b>Establecimiento y transferencias del comando</b><br>" +
                "La funci&oacuten del comando debe establecerse claramente al comienzo de las operaciones de respuestas al incidente. Cuando el comando es " +
                "transferido de una organizaci&oacuten o persona a otra, la transferencia debe incluir un periodo de transici&oacuten donde habr&aacute una superposici&oacuten para garantizar que la transferencia se d&eacute sin inconvenientes y que no se pierda informaci&oacuten importante al realizar el cambio." +

                "<br><br><b>La transferencia del comando se da cuando:</b><br>" +
                "&#8226; Una persona m&aacutes calificada asume el mando.<br>" +
                "&#8226; La situaci&oacuten del incidente cambia con el tiempo y en consecuencia la ley exige el cambio de comando.<br>" +
                "&#8226; Hay una cambio normal de personal en incidentes prolongados.<br>" +
                "&#8226; La respuesta al incidente concluye y la responsabilidad es transferida al organismo de origen.<br><br><hr>";

        String manejo4="<br><br><b>Despliegue</b><br>" +
                "El personal y el equipo deben responder solo cuando lo solicite o lo disponga la autoridad correspondiente. " +
                "Evadir los procedimientos establecidos de despliegue solo genera m&aacutes confusi&oacuten." +

                "<br><br><b>Comando unificado</b><br>" +
                "El comando unificado es una estructura que permite que todos los organismos de respuesta trabajen en conjunto, " +
                "compartiendo objetivos y recursos, sin comprometer la autoridad ni la responsabilidad de organismo individual. " +
                "La organizaci&oacuten sin fines de lucro trabajan a trav&eacutes de una estructura de comando unificado que opera como apoyo, " +
                "al manejo de emergencias, los funcionarios del gobierno y otros trabajadores de respuestas designados." +

                "<br><br><b>Formaci&oacuten de equipos</b><br>" +
                "Haz que cada miembro del equipo exponga sus habilidades y experiencias, luego: <br>" +
                "&#8226; Elija la posici&oacuten de ICS para la que est&eacuten m&aacutes calificados.<br>" +
                "&#8226; Cada persona del equipo debe cubrir al menos una posici&oacuten de ICS.<br>" +
                "&#8226; Una vez hallas elegido a una persona para cubrir cada rol, haz que pongan frente a ellos el identificador de posiciones ICS" +

                "<br><br><b>Descripci&oacuten de las funciones: comando de incidentes</b><br>" +
                "&#8226; Establece objetivos, estrategias y prioridades en el incidente.<br>" +
                "&#8226; Asume toda la responsabilidad por el incidente." +

                "<br><br><b>Operaciones</b><br>" +
                "&#8226; Define t&aacutecticas y recursos para alcanzar los objetivos.<br>" +
                "&#8226; Dirige la respuesta t&aacutectica alimentaci&oacuten, atenci&oacuten m&eacutedica, remoci&oacuten de escombros, etc.<br>" +

                "<br><br><b>Planificaci&oacuten</b><br>" +
                "&#8226; Recolecta, analiza y eval&uacutea informaci&oacuten.<br>" +
                "&#8226; Gestiona recursos, decide las necesidades para la alimentaci&oacuten y distribuci&oacuten masiva.<br>" +
                "&#8226; Mantiene la documentaci&oacuten registro." +

                "<br><br><b>Log&iacutestica</b><br>" +
                "&#8226; Provee recursos y servicios necesarios (PODS).<br>" +

                "<br><br><b>Financiero administrativo</b><br>" +
                "&#8226; Rendici&oacuten de cuentas para gastos, reclamos y compensatorio.<br>" +
                "&#8226; Provee los recursos necesarios.<br><br><hr>";


        ArrayList<Respuestas>  respuestasComandos= new ArrayList<Respuestas>();
        respuestasComandos.add(new Respuestas("Seguridad.", true));
        respuestasComandos.add(new Respuestas("Ingresos.", false));
        respuestasComandos.add(new Respuestas("Salud.", false));


        Preguntas preguntaComando = new Preguntas("Una función del sistema de manejo de emergencias.", respuestasComandos);

        ArrayList<AtencionesEmergencias>  comandosEmergencias = new ArrayList<AtencionesEmergencias>();
        comandosEmergencias.add(new AtencionesEmergencias(R.drawable.manejo_emergencia1,manejo1, "Manejo de Emergencias", preguntaComando));
        comandosEmergencias.add(new AtencionesEmergencias(R.drawable.emergencia2,manejo2, "", preguntaComando));
        comandosEmergencias.add(new AtencionesEmergencias(R.drawable.emergencia3,manejo3, "", preguntaComando));
        comandosEmergencias.add(new AtencionesEmergencias(R.drawable.emergencia4,manejo4, "", preguntaComando));


        //-----------------------Triage---------------------------------------------------------------------------------------------
        String contenidoTriage1="<br><br>Triaje procede de la palabra francesa triage que significa clasificar y es el conjunto de procedimientos mediante el cual se hace una revisi&oacuten y clasificaci&oacuten de v&iacutectimas cuando su n&uacutemero excede los recursos disponibles de atenci&oacuten inmediata para establecer prioridades en atenci&oacuten y evacuaci&oacuten. " +
                "La persona a cargo de triaje debe estar en la capacidad de realizar un reconocimiento r&aacutepido de los pacientes, tomar decisiones inmediatas y realizar un etiquetado &aacutegil y preciso; en la medida de lo posible debe tener experiencia y entrenamientos previos para lograr mayor precisi&oacuten y exactitud." +

                "<br><br><b>Objetivos del triaje.</b>" +
                "<br>" +
                "<br>&#8226; Asistencia temprana." +
                "<br>&#8226; Aplicaci&oacuten de maniobras salvadoras." +
                "<br>&#8226; Determinar grado de urgencia." +
                "<br>&#8226; Documentar a los pacientes. " +
                "<br>&#8226; Controlar flujo de v&iacutectimas." +
                "<br>&#8226; Asignar &aacutereas de atenci&oacuten." +
                "<br>&#8226; Distribuir al personal por &aacutereas asistenciales." +
                "<br>&#8226; Iniciar medidas diagn&oacutesticas." +
                "<br>&#8226; Iniciar prehospitalarias." +
                "<br>&#8226; Control temprano de infecciones." +
                "<br>&#8226; Preparar la atenci&oacuten al p&uacuteblico." +
                "<br>&#8226; Atenci&oacuten a los familiares." +

                "<br><br>Con la finalidad de hacer m&aacutes objetivos los sistemas, internacionalmente se ha adoptado un c&oacutedigo de colores que, independientemente del sistema, dividir&aacute a los pacientes en cuatro categor&iacuteas:" +
                "<br>&#8226; <b>ROJO: </b>Pacientes que precisan asistencia inmediata y una vez proporcionada son recuperables, es decir, tienen pron&oacutestico aceptable." +
                "<br>&#8226; <b>AMARILLO: </b>Pacientes que precisan asistencia hospitalaria, pero que se puede esperar para realizar la evacuaci&oacuten. Precisan unos cuidados m&iacutenimos previos a la misma."+
                "<br>&#8226; <b>VERDE: </b>Pacientes que no precisan asistencia hospitalaria m&eacutedica inmediata, o en todo caso pueden ser trasladados en veh&iacuteculos no sanitarios. Su atenci&oacuten puede demorarse m&aacutes de 6 horas."+
                "<br>&#8226; <b>NEGRO: </b>Este color se utiliza para aquellas personas fallecidas, por lo cual no amerita traslado ni asistencia hospitalaria.<br><br><hr>";

        String contenidoTriage2="<br><br><b>1- Escena I: </b>Observe atentamente el lugar en donde ocurri&oacute la emergencia, para corroborar que es segura para acercarse y brindar ayuda. " +
                "Si hay personas cercas del accidente pregunte como sucedi&oacute y solicite que llamen a la Cruz Roja y Bomberos." +
                "<br><br><b>2- Clasificaci&oacuten de personas leves (color verde): </b>Observe atentamente a las personas y oriente que las personas que puedan caminar se alejen del lugar del accidente y se ubiquen en una zona m&aacutes segura. A estas personas deber&aacute entregarles la tarjeta con la clasificaci&oacuten verde." +
                "<br><br><b>3- Clasificaci&oacuten de personas heridas leves (color amarillo):  </b>Observe y examine atentamente a las personas y pregunte a cada herido como se llama, sabe que sucedi&oacute y como est&aacute esto con el objetivo de valorar su estado de conciencia." +
                "<br><br><b>Criterios para colocar la tarjeta con la clasificaci&oacuten Amarilla: </b>" +
                "<br>&#8226; Heridas grandes no hemorr&aacutegicas. " +
                "<br>&#8226; Heridas articulares profundas." +
                "<br>&#8226; Quemaduras de 2&ordm; y 3&ordm; entre el 10% y 30%." +
                "<br>&#8226; Alergias con manifestaciones cut&aacuteneas." +
                "<br>&#8226; Fractura de huesos largos cerradas y huesos cortos abierta." +
                "<br>&#8226; Luxaciones de gran articulaci&oacuten sin compromiso." +
                "<br>&#8226; Lesiones en los ojos graves no penetrantes." +
                "<br>&#8226; Traumatismo tor&aacutecico y abdominal sin compromisos." +
                "<br>&#8226; Obedece &oacuterdenes sencillas." +

                "<br><br><b>4- Clasificaci&oacuten de personas de atenci&oacuten inmediatas (Roja): </b>Observe y examine atentamente al herido y pregunte como se llama, sabe que sucedi&oacute y como est&aacute esto con el objetivo de valorar su estado de conciencia." +
                "<br><br><b>Criterios para colocar la tarjeta con la clasificaci&oacuten Roja:</b>" +
                "<br>&#8226; No camina." +
                "<br>&#8226; Inconsciente." +
                "<br>&#8226; Heridas grandes hemorr&aacutegicas." +
                "<br>&#8226; Quemaduras de 2&ordm; y 3&ordm; entre el 31% y 50% en cara y mano." +
                "<br>&#8226; Fractura de huesos largos abiertas." +
                "<br>&#8226; Luxaciones de grandes articulaciones con compromiso." +
                "<br>&#8226; Lesiones en los ojos graves penetrantes." +
                "<br>&#8226; Hipotermia." +
                "<br>&#8226; Traumatismos tor&aacutecicos y abdominales graves." +

                "<br><br><b>5- Clasificaci&oacuten de personas Muertas/ no recuperables (Negra): </b>" +
                "Observe y examine atentamente al herido y pregunte como se llama, sabe que sucedi&oacute y como esta; esto con el objetivo de valorar su estado de conciencia." +
                "<br><br><b>Criterios para colocar la tarjeta con la clasificaci&oacuten Roja:</b>" +
                "<br>&#8226; No camina." +
                "<br>&#8226; No respira." +
                "<br>&#8226; Alineaci&oacuten de v&iacuteas &aacutereas sigue sin respirar." +
                "<br>&#8226; No responde (Muerte).<br><br><hr>";

        String contenidoTriage3="<br><br><b><h2>Persona ideal para realizar el triaje</h2></b>" +
                "<br>&#8226; Que sea un facultativo experto en emergencias m&eacutedicas con gran sentido cl&iacutenico." +
                "<br>&#8226; Con formaci&oacuten multidisciplinaria y cualidades persona-les que abarquen desde las dotes de mando a la serenidad, la capacidad de organizaci&oacuten y hasta imaginaci&oacuten." +
                "<br><br><b>Reglas del triaje:</b>" +
                "<br>&#8226; R&aacutepido." +
                "<br>&#8226; Completo" +
                "<br>&#8226; Preciso y seguro." +
                "<br>&#8226; retrasar atenci&oacuten de victimas que esperan." +
                "<br>&#8226; No retener a los ya clasificados." +
                "<br>&#8226; 30 segundos para clasificar un muerto." +
                "<br>&#8226; 1 min. Para clasificar un herido leve." +
                "<br>&#8226; Ninguna v&iacutectima debe ser evacuada sin ser clasificada" +
                "<br>&#8226; Ante la duda de clasificar una v&iacutectima, hacerlo siempre en la categor&iacutea superior." +
                "<br>&#8226; Excepciones: " +
                "             - Oscuridad." +
                "             - Malas condiciones meteorol&oacutegicas." +
                "             - Riesgo potencial." +
                "<br><br><b>M&eacutetodos de clasificaci&oacuten.</b>" +
                "<br>&#8226; METTAG" +
                "<br>&#8226; S.T.A.R.T" +
                "<br>&#8226; S.H.O.R.T<br><br><br><br><hr>";


        ArrayList<Respuestas>  respuestasTriage= new ArrayList<Respuestas>();
        respuestasComandos.add(new Respuestas("Seguridad.", true));
        respuestasComandos.add(new Respuestas("Ingresos.", false));
        respuestasComandos.add(new Respuestas("Salud.", false));


        Preguntas preguntaTriage = new Preguntas("Una funci&oacuten del sistema de manejo de emergencias.", respuestasTriage);

        ArrayList<AtencionesEmergencias>  triages = new ArrayList<AtencionesEmergencias>();
        triages.add(new AtencionesEmergencias(R.drawable.imgtriaje1,contenidoTriage1, "Triaje.", preguntaTriage));
        triages.add(new AtencionesEmergencias(R.drawable.imgtriaje2, contenidoTriage2, "¿Cómo aplicar start?", preguntaTriage));
        triages.add(new AtencionesEmergencias(R.drawable.imgtriaje3,contenidoTriage3, "", preguntaTriage));





        //-------------------------------Fracturas-Heridas-Hemorragias--------------------------------------------------

        String herida1="<br><br>Es la separaci&oacuten de los tejidos de la piel, que puede dejar al descubierto otras partes del cuerpo como los huesos y otros &oacuterganos del ser humano que se encuentran internamente."
                + "<br><br><b>Elementos que pueden producir una herida</b><br>" +
                "&#8226; <b>Cortantes :</b> Bordes rectil&iacuteneos (cuchillo, gillette, navaja).<br>" +
                "&#8226; <b>Lacerantes :</b> Bordes irregulares (lat&oacuten, sierra, vidrio).<br>" +
                "&#8226; <b>Punzantes:</b> Orificio a veces con salida (punz&oacuten, clavos, agujas).<br>" +
                "&#8226; <b>Contusas:</b> Golpes fuertes (pedradas, martillazos).<br>" +
                "&#8226; <b>Corto Punzante:</b> Bordes rectil&iacuteneos  y orificio (verruguilla, navaja).<br>" +
                "&#8226; <b>Avulsiva:</b> Desgarre o p&eacuterdida de un miembro o parte del cuerpo.<br><br><hr>";

        String hemorragea1="<br><br>Es la p&eacuterdida abundante de sangre al romperse un vaso sangu&iacuteneo" +
                "<br><br><b>Tipos de hemorragias: </b><br>" +
                "&#8226; Hemorragia Arterial: Sangre de color rojo que sale de forma intermitente coincidiendo con los latidos del coraz&oacuten.<br>" +
                "&#8226; Hemorragias Venosas: Sangre de color oscuro y que sale de forma continua.<br>" +
                "&#8226; Hemorragia Capilar: Sangrado de color  rojo que sale de forma lenta.<br>" +

                "<br><br><b>Clasificaci&oacuten  de las Hemorragias: </b><br>" +
                "&#8226; Hemorragia Externa: Se acompa&ntildea de una herida en la piel y se observa salida de sangre hacia afuera.<br>" +
                "&#8226; Hemorragia Interna: El sangrado es interno. Este sangrado puede salir por los orificios naturales del cuerpo, convirti&eacutendose  en hemorragia  exteriorizada.<br>"+

                "<br><br><b><h2>Primeros auxilios para hemorragias</h2></b>"+
                "<br>&#8226; <b>Haga  presi&oacuten directa:</b> Use guantes y ejerza presi&oacuten sobre la herida.<br>" +
                "&#8226; <b>Elevaci&oacuten:</b> Elevar las extremidades afectadas (piernas o brazos), para aminorar la salida de sangre al sitio de la herida. Si no existen fracturas u objetos ensartados  se elevan las extremidades afectadas a un nivel m&aacutes alto que el del coraz&oacuten.<br>" +
                "&#8226; <b>Presi&oacuten Indirecta:</b> Usando la yema de los dedos, la palma de la mano, se apretar&aacute en el sitio afectado donde podamos prensar la arteria por donde sale la sangre contra el hueso, a fin de evitar el paso de la sangre.<br><br><hr>";

        String contenidoFractura1="<br><br>Es la ruptura parcial o total de un hueso, causadas por factores externos o internos como enfermedades propias de los huesos." +
                "<br><b>&#8226; Agentes externos: </b>Son provocados por trauma, fuerza desproporcionada, movimiento desmedido que ocasionan esguinces, fracturas y luxaciones.\n" +
                "<br><b>&#8226; Agentes Internos</b>: Enfermedades que afectan el sistema &oacuteseo; ejemplo: Osteoporosis, leucemia y c&aacutencer de huesos" +
                "<br><br><b>Signos y S&iacutentomas de Fracturas:</b><br>" +
                "&#8226; Deformidad.<br> " +
                "&#8226; Inflamaci&oacuten.<br> " +
                "&#8226; Incapacidad de movimiento.<br> " +
                "&#8226; Aumento o acortamiento del miembro.<br>" +
                "&#8226; &aacuterea lesionada  entumecida y fr&iacutea.<br> " +
                "&#8226; La piel tiene un color Azul." +
                "<br><br><b>Primeros auxilios para fracturas</b>"+
                "<br><br>Los huesos y articulaciones fracturadas o lesionadas deben ser inmovilizados  para que de esta forma puedan prevenir mayores lesiones y disminuir  el dolor." +
                "<br><br><b>En la atenci&oacuten de estas lesiones se utilizan:</b> f&eacuterulas, vendas de rollo y vendas triangulares.<br><br><hr>";

        String contenidoFractura2="<br><br><b><h2></h2></b>"
                +"<br>Un entablillado puede ser preparado comercialmente o improvisado. Tambi&eacuten  es posible utilizar una parte del cuerpo que no se encuentre lesionada, por  ejemplo: La otra pierna o el costado del cuerpo." +
                "<br><br><b>&iquest;Qu&eacute hacer?</b>" +
                "<br>&#8226; No haga nada que le cause m&aacutes dolor a la persona.<br>" +
                "&#8226; Inmovilice el &aacuterea lesionada en posici&oacuten de mayor comodidad.<br>" +
                "&#8226; Examine la circulaci&oacuten distal antes y despu&eacutes de la inmovilizaci&oacuten.<br>" +
                "&#8226; Tranquilizar a la persona afectada.<br>" +
                "&#8226; Visualizar la fractura y estabilizar manualmente.<br>" +
                "&#8226; Seleccionar el material de inmovilizaci&oacuten adecuado.<br><br><hr>";

        ArrayList<Respuestas>  respuestaHeridas = new ArrayList<Respuestas>();
        respuestaHeridas.add(new Respuestas("Perdida de visi&oacuten", false));
        respuestaHeridas.add(new Respuestas("Dolor intenso en el &aacuterea afectada", true));
        respuestaHeridas.add(new Respuestas("P&eacuterdida de audici&oacuten", false));


        Preguntas preguntaHerida = new Preguntas("S&iacutentomas de una fractura", respuestaHeridas);

        ArrayList<AtencionesEmergencias>  fracHeridaHemo = new ArrayList<AtencionesEmergencias>();
        fracHeridaHemo.add(new AtencionesEmergencias(R.drawable.heridas1info,herida1, "Heridas", preguntaHerida));
        fracHeridaHemo.add(new AtencionesEmergencias(R.drawable.heridas2info,hemorragea1, "Hemorragia", preguntaHerida));
        fracHeridaHemo.add(new AtencionesEmergencias(R.drawable.heridas2info,contenidoFractura1, "Fracturas", preguntaHerida));
        fracHeridaHemo.add(new AtencionesEmergencias(R.drawable.heridas2info,contenidoFractura2, "Inmovilización", preguntaHerida));





        //---------------------------------------Transporte y camillaje----------------------------------------------------------



        String contenidoTransporte1="<br><br><b>Objetivos generales</b>" +
                "<br><br>&#8226; El objetivo es evitar que las lesiones existentes empeoren o que con su accionar se originen otras nuevas." +
                "<br>&#8226; Para lograr este objetivo, es necesario garantizar un adecuado transporte desde el &aacuterea de impacto a un lugar seguro para su evaluaci&oacuten y estabilizaci&oacuten; utilizar diferentes elementos como gasa, pa&ntildeuelos, telas, sillas, camillas, tablas, etc. los que permiten vendar e inmovilizar las distintas lesiones encontradas." +
                "<br><br><b>Considera estos tres aspectos.</b>" +
                "<br>&#8226; Vendajes." +
                "<br>&#8226; Inmovilizaci&oacuten." +
                "<br>&#8226; Traslado de Pacientes.<br><br><hr>";

        String contenidoTransporte2="<br><br>&#8226; Los vendajes son procedimientos que tienen como objetivo cubrir con una venda, una zona lesionada" +
                "<br>&#8226; Venda: Es una porci&oacuten de gasa, tela o cualquier otro material que pueda utilizarse para los fines antes mencionados; por lo general, las vendas son de dos tipos : Las triangulares y enrolladas." +
                "<br><br><b>Tipos de Vendajes</b>" +
                "<br><b>Vendaje en espiral: </b>Se emplea una venda el&aacutestica o semiel&aacutestica porque se puede adaptar a la zona que se va a vendar, se utiliza para sujetar gasas, ap&oacutesitos o f&eacuterulas en brazos, mano, muslo y piernas." +
                "<br><b>M&eacutetodo: </b>Seleccione el tama&ntildeo adecuado, inicie el vendaje desde la parte m&aacutes distal en direcci&oacuten a la circulaci&oacuten  venosa, las vueltas de la venda ascienden en espiral, de tal manera, que cada vuelta cubra dos tercios de la vuelta anterior, luego fije la punta con un nudo, esparadrapo o un gancho." +
                "<br><br><b>Vendaje en ocho: </b>Esta t&eacutecnica se aplica en las articulaciones (tobillos, rodilla, codo, etc.). &uacutetil para sujetar ap&oacutesitos ( utilizados para control de hemorragias)  e inmovilizar." +
                "<br><b>M&eacutetodo: </b>D&eacute una vuelta circular al inicio, seguida de un cruce de la venda en forma de ocho, puede terminar con otra vuelta" +
                "<br><br><b>Vendaje de la mano: </b>Puede realizarse en forma oblicua desde la palma de la mano hacia la mu&ntildeeca y luego terminar cubriendo los dedos o dej&aacutendolos libres e incluyendo el pulgar." +
                "<br><br><b>Vendaje de los dedos: </b>Cuando se quiere vendar un dedo es conveniente dejar libre su extremidad para poder vigilar la circulaci&oacuten. Se comenzar&aacute en la mu&ntildeeca, haciendo 3 &oacute 4 vueltas alrededor del dedo vendado" +
                "<br><br><b>Vendaje de cabestrillo: </b>Con una venda, se mide el largo adecuado, se amarra en sus puntas y se coloca pasando por debajo del antebrazo para sostenerlo e inmovilizarlo en el movimiento de abajo y arriba, el otro extremo se fija sobre la nuca (el brazo debe estar de forma tal que la mano est&eacute " +
                "un poco m&aacutes alta que el codo) tiene como inconveniente que no inmoviliza completamente el miembro superior, aunque podemos limitar m&aacutes el movimiento si pasamos otra venda o pa&ntildeuelo en forma trasversal sobre la parte media del t&oacuterax." +
                "<br><br><b>Vendaje de la cabeza: </b>Para ello lo m&aacutes utilizado es el vendaje de capelina, primero se hacen dos circulares " +
                "alrededor de la cabeza, al llegar a la regi&oacuten occipital, se hace un inverso en &aacutengulo recto que llevar&aacute la venda a la frente donde se hace otro inverso, esta maniobra se " +
                "repite hasta cubrir totalmente la cabeza, luego se repite el vendaje circular para fijar los extremos de las vueltas del frente a la parte posterior.<br><br><hr>";



        String contenidoTransporte3="<br><br>&#8226; Uno de los elementos m&aacutes importantes en el manejo de las lesiones &oacuteseas (fracturas, luxaciones), de partes blandas (heridas, contusiones) y de las articulaciones (esguince) es la inmovilizaci&oacuten firme e ininterrumpida de las &aacutereas correspondientes." +
                "<br>&#8226; Ya, al explicar las t&eacutecnicas para vendajes, se incorporaron algunos conceptos y modos de inmovilizar, lo cual se perfecciona si utilizamos m&eacutetodos manuales o con aditamentos." +
                "<br><br><b>&iquest;Qu&eacute se logra al inmovilizar una lesi&oacuten?</b>" +
                "<br>&#8226; Alivio del dolor, ello tambi&eacuten previene el shock." +
                "<br>&#8226; Se evita incrementar el da&ntildeo a los tejidos cercanos a ella, al reducir el movimiento de los extremos de los huesos que ahora tienen una superficie irregular." +
                "<br>&#8226; Disminuir el sangramiento (se forma un co&aacutegulo en el sitio de la lesi&oacuten)." +
                "<br><br><b>Principios b&aacutesicos de las inmovilizaciones.</b>" +
                "<br>&#8226; Mantener las l&iacuteneas y ejes del cuerpo." +
                "<br>&#8226; Mantener las articulaciones en posici&oacuten funcional." +
                "<br>&#8226; Acolchar o almohadillar en los sitios donde las eminencias &oacuteseas se ponen en contacto con   la f&eacuterula." +
                "<br>&#8226; No tratar de reducir fracturas en el sitio del accidente." +
                "<br>&#8226; En fracturas de huesos por su parte central, inmovilice al menos una articulaci&oacuten por encima y una por debajo." +
                "<br>&#8226; Inmovilice el hueso que est&aacute por encima y por debajo de la lesi&oacuten, si hay fracturas en articulaciones." +
                "<br>&#8226; La venda no debe estar ni muy apretada ni muy floja." +
                "<br>&#8226; Si existe una herida, c&uacutebrala con un ap&oacutesito est&eacuteril antes de colocar la f&eacuterula y no anude sobre ella." +
                "<br><br><b>Principios para el manejo de un traumatismo de columna:</b>" +
                "<br>&#8226; Efect&uacutee inmovilizaci&oacuten manual alineada." +
                "<br>&#8226; Eval&uacutee y resuelva el ABCD de la resucitaci&oacuten." +
                "<br>&#8226; Concluya la revisi&oacuten sistem&aacutetica total y valore la respuesta al movimiento, trastornos de la sensibilidad o la circulaci&oacuten en las extremidades." +
                "<br>&#8226; Inmovilice el tronco." +
                "<br>&#8226; Coloque almohadillamiento debajo de la cabeza (y del tronco en el ni&ntildeo)." +
                "<br>&#8226; Inmovilice la cabeza." +
                "<br>&#8226; Inmovilice las piernas y los brazos." +
                "<br>&#8226; Reeval&uacutee el ABC y traslade.(Abrir v&iacuteas a&eacutereas, Busque respiraci&oacuten, Controle circulaci&oacuten)." +
                "<br><br><b>Inmovilizaci&oacuten manual de la columna cervical.</b>" +
                "<br>&#8226; Para inmovilizar la columna cervical existen varias t&eacutecnicas, en dependencia de la posici&oacuten y estado del lesionado." +
                "<br>&#8226; <b>Est&aacute contraindicado llevar la cabeza a la posici&oacuten neutral alineada si:</b>" +
                "<br>&#8226; Existe contractura o dolor de los m&uacutesculos del cuello." +
                "<br>&#8226; La maniobra compromete la v&iacutea a&eacuterea o la ventilaci&oacuten." +
                "<br>&#8226; Desencadena o empeora trastornos neurol&oacutegicos (hormigueo, calambres, par&aacutelisis o dolor)." +
                "<br><br><b>Inmovilizaci&oacuten para retirar un casco: </b>" +
                "<br>&#8226; La mayor&iacutea de las complicaciones cervicales en pacientes motociclistas se debe al retiro del casco de una forma no correcta." +
                "<br>&#8226; Debe hacerse entr&eacute dos personas, el primero se arrodilla detr&aacutes de la cabeza de la v&iacutectima, con sus palmas de las manos contra los lados del casco y los dedos flexionados sobre su margen inferior, tratando de llevar la cabeza a la posici&oacuten neutral alineada." +
                "<br>&#8226; El segundo rescatador tambi&eacuten arrodillado, abre y quita la careta, eval&uacutea la v&iacutea a&eacuterea y desabrocha las correas del ment&oacuten." +
                "<br>&#8226; Luego coloca una mano en la parte posterior y la otra en la mand&iacutebula para realizar una inmovilizaci&oacuten manual de frente." +
                "<br>&#8226; El primer socorrista, ahora retira cuidadosamente el casco pudiendo ser necesario un cambio de manos en el momento en que el casco levanta la parte posterior de la cabeza. Para terminar, se produce un nuevo cambio de manos en el cual el primer rescatador queda realizando la inmovilizaci&oacuten manual desde la posici&oacuten de atr&aacutes.<br><br><hr>";

        String contenidoTransporte4="<br><br><b><h2>Inmovilizaci&oacuten  de la columna vertebral.</h2></b>" +
                "<br>&#8226; Inmovilizaci&oacuten de la columna cervical con collar&iacuten son dispositivos que aunque no inmovilizan  completamente la columna cervical, limitan los movimientos de la cabeza en un 50-75 %." +
                "<br>&#8226; Para que sea efectivo, debe seleccionarse el tama&ntildeo adecuado y colocarlo con un movimiento m&iacutenimo sobre la cintura escapular y debajo de la mand&iacutebula." +
                "<br>&#8226; Reglas para su uso: No debe estar ni flojo ni apretado (comprime las venas del cuello), debe permitir la apertura de la boca (&uacutetil si hay v&oacutemitos), no debe dificultar la respiraci&oacuten y debe aplicarse luego que la cabeza haya sido colocada en posici&oacuten neutral alineada. " +
                "<br>&#8226; Un collar&iacuten cervical puede improvisarse con un pa&ntildeuelo Triangular, bolsas de suero, o el uso de cuatro gorras." +
                "<br><br>Inmovilizaci&oacuten de la columna con tabla espinal larga, es una forma de inmovilizaci&oacuten muy efectiva, que permite un traslado " +
                "seguro y con un m&iacutenimo de personas . Para colocar la tabla, las correas (t&oacuterax, abdomen al nivel de las crestas il&iacuteacas, muslos, " +
                "tobillos, cabeza y ment&oacuten) deben estar sueltas y listas. Coloque al paciente boca arriba, alineado, los brazos al lado del cuerpo, con la palma de las manos hacia adentro.<br><br><hr>";


        String contenidoTransporte5="<br><b><h2>Inmovilizaci&oacuten de los brazos y piernas.</h2></b>" +
                "<br>Por seguridad, los brazos deben ser sujetados a la tabla antes de mover al paciente, las palmas de las manos hacia adentro (pegadas al cuerpo), sujetados con una correa sobre los antebrazos." +
                "<br><b><h2>Traslado de pacientes.</h2></b>" +
                "<br>&#8226; No siempre es posible brindar asistencia m&eacutedica en el sitio donde se produce una emergencia; por ello, es necesario el traslado a otro sitio (fuera del escenario o a centros de salud) donde las condiciones sean m&aacutes adecuadas o donde no exista peligro para el rescatista  o la v&iacutectima." +
                "<br>&#8226; El traslado de enfermos debe realizarse con todas las condiciones que garanticen la estabilidad y se deben utilizar los veh&iacuteculos y medios adecuados. Mueva a la persona s&oacutelo cuando sea absolutamente necesario, pues ello puede empeorar lesiones existentes." +
                "<br>&#8226; Para el traslado de pacientes, debemos tener en cuenta dos situaciones: El transporte desde el sitio del evento hasta un lugar seguro para su evaluaci&oacuten y manejo y su evacuaci&oacuten hacia los centros de salud, incluidos los hospitales." +
                "<br><br><b>T&eacutecnicas Empleadas: </b>" +
                "<br>&#8226; Traslado sin medios." +
                "<br>&#8226; Arrastre." +
                "<br>&#8226; Soporte o muleta humana." +
                "<br>&#8226; Cargue en brazos." +
                "<br>&#8226; Cargue de bombero." +
                "<br>&#8226; Silla de dos y de cuatro manos." +
                "<br>&#8226; T&eacutecnica de tres o cuatro socorristas." +
                "<br>&#8226; Extracci&oacuten desde un auto por un socorrista." +
                "<br><br><b>Traslado entre tres o cuatro Rescatistas.</b>" +
                "<br>Para movilizar un herido hacia la camilla (esta debe ir hacia &eacutel y no al rev&eacutes), el lesionado debe sostenerse por, al menos seis puntos de apoyo: " +
                "<br>&#8226; Un punto bajo el conjunto cabeza y nuca." +
                "<br>&#8226; De 3 a 5 puntos bajo el tronco." +
                "<br>&#8226; Dos puntos debajo de los miembros inferiores.<br><br><hr>";

        String contenidoTraslado6="<br><br><b><h2>Extracci&oacuten desde un auto por un Rescatista.</h2></b>" +
                "<br>&#8226; En esta variante, el Rescatista  abre la puerta y trata de rotar al lesionado de forma tal que se pueda ubicar detr&aacutes, su brazo" +
                "derecho lo corre por debajo de la axila del mismo lado del paciente para, con la mano, sostenerlo por la mand&iacutebula y hacer " +
                "f&eacuterula con el antebrazo de forma tal que se mantenga alineada la columna cervical y tor&aacutecica." +
                "<br>&#8226; Su otro brazo lo desplaza por debajo de la otra axila y sostiene el brazo derecho del paciente a nivel de la parte media del antebrazo." +
                "<br>&#8226; Una vez sostenido el paciente, se arrastra hacia atr&aacutes de forma tal que se traslade a un lugar seguro para realizar su evaluaci&oacuten." +
                "<br><br><b>Camilla de Costales.</b>" +
                "<br>Esta se elabora con dos costales del mismo tama&ntildeo y dos palos (varas) que sobrepasen el tama&ntildeo del paciente, " +
                "se hacen dos agujeros al fondo del costal por donde se pasa los palos, convirtiendo en una camilla, para el " +
                "traslado de la victima se puede usas una manta." +
                "<br><br><b><h2>Espera para el traslado</h2></b>" +
                "<br>Una vez concluida la evaluaci&oacuten del ABC y realizada las curas e inmovilizaci&oacuten de lesiones, puede ser necesaria la espera para el traslado hacia los centros de salud, lo m&aacutes adecuado es tener un empaquetamiento sobre una tabla espinal larga, pero ello en ocasiones no es posible dado lo escaso de recursos, fundamentalmente frente a lesionados m&uacuteltiples, una variante es colocarlo en posici&oacuten de rescate o envolverlo con una manta o s&aacutebana.<br><br><hr>";
        String contenidoTraslado7="<br>&#8226; Coloque a la v&iacutectima boca arriba, en posici&oacuten neutral alineada, Tome el brazo m&aacutes cercano a usted y el&eacutevelo formando &aacutengulo recto en el codo, con el antebrazo en paralelo con el cuerpo y la palma de la mano hacia arriba." +
                "<br>&#8226; Traiga el otro brazo sobre el t&oacuterax de forma tal que la parte posterior de la mano quede en contacto con la mejilla m&aacutes cercana a usted y sost&eacutengala con una mano con su otra mano, eleve la pierna m&aacutes alejada sosteni&eacutendola al nivel de la rodilla, luego con un movimiento hacia s&iacute, rote en bloque a la v&iacutectima, de esta forma, una mano queda debajo de la boca, lo que eleva la cabeza del suelo permitiendo una mejor respiraci&oacuten y evitando que de producirse un v&oacutemito, este sea ,por otro lado al quedar una pierna hacia delante y con la rodilla en &aacutengulo recto, evita el movimiento en esta direcci&oacuten." +
                "<br><br><hr>";

        String contenidoTraslado8="<br><br><hr>";

        ArrayList<Respuestas>  respuestasTransporte = new ArrayList<Respuestas>();
        respuestasTransporte.add(new Respuestas("Perdida de visi&oacuten", false));
        respuestasTransporte.add(new Respuestas("Dolor intenso en el &aacuterea afectada", true));
        respuestasTransporte.add(new Respuestas("P&eacuterdida de audici&oacuten", false));


        Preguntas preguntaTransporte = new Preguntas("S&iacutentomas de una fractura", respuestaHeridas);

        ArrayList<AtencionesEmergencias>  transporte = new ArrayList<AtencionesEmergencias>();
        transporte.add(new AtencionesEmergencias(R.drawable.imgtransporte1,contenidoTransporte1, "Transporte y camillaje", preguntaTransporte));
        transporte.add(new AtencionesEmergencias(R.drawable.imgvendaje1,contenidoTransporte2, "Vendajes", preguntaTransporte));
        transporte.add(new AtencionesEmergencias(R.drawable.inmobilizacioninfo2,contenidoTransporte3, "Inmovilización", preguntaTransporte));
        transporte.add(new AtencionesEmergencias(R.drawable.imgimovilizacion4,contenidoTransporte4, "Inmovilización", preguntaTransporte));
        transporte.add(new AtencionesEmergencias(R.drawable.imginmovilizacion5,contenidoTransporte5, "Inmovilización", preguntaTransporte));
        transporte.add(new AtencionesEmergencias(R.drawable.imgtraslado6,contenidoTraslado6, "Extracción desde un auto.", preguntaTransporte));
        transporte.add(new AtencionesEmergencias(R.drawable.imgtraslado7,contenidoTraslado7, "Posición de rescate.", preguntaTransporte));
        transporte.add(new AtencionesEmergencias(R.drawable.imgtraslado8,contenidoTraslado8, "Otras Posiciones.", preguntaTransporte));

        //------------------------------Rescate acuatico----------------------------------------------------------------------
        String contenidoRescateAcuatico1="<br><br><b><h2>Objetivos generales.</h2></b>" +
                "&#8226; Actuar en condiciones de posible emergencia, transmitiendo con serenidad, celeridad las se&ntildeales de alarma y aplicando los medios de seguridad establecidos." +
                "<br>&#8226; Resolver las contingencias que se presenten en relaci&oacuten a las personas, las instalaciones y los equipos o materiales, informando de inmediato a los servicios de emergencia 911 cuando las repercusiones o la problem&aacutetica superen su &aacutembito de actuaci&oacuten." +
                "<br>&#8226; Administraci&oacuten de primeros auxilios en caso de accidente o enfermedad." +
                "<br>&#8226; Ense&ntildear las t&eacutecnicas propias de la actividad utilizando los equipos de salvamento y/o socorrismo, demostrando los movimientos y corrigiendo los errores de ejecuci&oacuten de los participantes." +
                "<br>&#8226; Mantenerse informado sobre las &uacuteltimas aportaciones t&eacutecnicas o cient&iacuteficas relacionadas con el salvamento y los primeros auxilios que pueden ser beneficiosos en su trabajo, con el fin de incorporar las nuevas t&eacutecnicas y tendencias, estando actualizando en todo momento y puesto al d&iacutea en cuanto a nuevos equipos, materiales y t&eacutecnicas que  se conozcan." +
                "<br>&#8226; Utilizar y buscar fuentes de informaci&oacuten y formaci&oacuten relacionadas con el ejercicio de la profesi&oacuten que posibiliten el conocimiento y la inserci&oacuten en el sector de las actividades f&iacutesicas y/o deportivas,  la evoluci&oacuten y adaptaci&oacuten de las capacidades profesionales propias a los cambios tecnol&oacutegicos y organizativos que se producir&aacuten a lo largo de toda la vida activa." +
                "<br><b><h2>Objetivos espec&iacuteficos.</h2></b>" +
                "Al termino de este m&oacutedulo, el alumno deber&aacute haber adquirido las siguientes capacidades:" +
                "<br>&#8226; Identificar los primeros auxilios que se deben prestar para cada tipo de lesi&oacuten o enfermedad." +
                "<br>&#8226; Aplicar las t&eacutecnicas de los primeros auxilios en funci&oacuten del tipo de accidente o lesi&oacuten seg&uacuten los protocolos establecidos." +
                "<br>&#8226; Analizar las posibilidades de peligros en las instalaciones o zonas acu&aacuteticas naturales y los procedimientos a seguir para realizar el rescate acu&aacutetico." +
                "<br>&#8226; Realizar con seguridad y eficacia las maniobras de salvamento acu&aacutetico." +
                "<br><b><h2>Requerimientos.</h2></b>" +
                "&#8226; Seguir rigurosamente los puntos de prevenci&oacuten y aviso para optimizar la seguridad (zonas mas peligrosas)." +
                "<br>&#8226; Reconocer en las personas signos de tener problemas para nadar y/o mantenerse a flote." +
                "<br>&#8226; Decidir con rapidez, tras analizar la situaci&oacuten globalmente, y teniendo en cuenta el estado de la persona en peligro de ahogamiento y los recursos disponibles, la manera de prestarle auxilio (lanzamiento de cuerda, boya, flotador, etc, tipo de rescate, rescate a nado, con ayuda de medios auxiliares, entre varios socorristas, etc, selecci&oacuten de entrada al agua, seg&uacuten condici&oacuten, profundidad, r&aacutepidas,  posibles corrientes, lentas  o turbulentas)." +
                "<br>&#8226; Aproximaci&oacuten a la persona que hay que rescatar o socorrer nadando a cualquier estilo, pero sin perderla de vista y accediendo al mismo por la espalda." +
                "<br>&#8226; Extraer del agua a la persona auxiliada, utilizando las t&eacutecnicas pertinentes y apropiadas en funci&oacuten de sus caracter&iacutesticas y del medio acu&aacutetico donde se realice (recuerde el agua en el estomago no esta matando el paciente, es el agua en sus pulmones )." +
                "<br>&#8226; Valorar el estado de gravedad de los enfermos o accidentados, estableciendo la prioridad de atenci&oacuten y/o evacuaci&oacuten." +
                "<br>&#8226; Aplicar los cuidados de urgencia siguiendo los protocolos y puntos de actuaci&oacuten establecidos (RCP/ RA seg&uacuten sea el caso)." +
                "<br>&#8226; Establecer comunicaci&oacuten con los servicios de emergencia 911, si la situaci&oacuten lo exigiera." +
                "<br>&#8226; Realizar en caso de necesidad urgente la evacuaci&oacuten y/o traslado del enfermo o accidentado en condiciones de seguridad y utilizando el sistema m&aacutes adecuado a la lesi&oacuten y nivel de gravedad.<br><br><hr>";

        String contenidoRescateAcuatico2="<br><br><b><h2>Zonas con Diferente Prioridad de Observaci&oacuten e Intervenci&oacuten:</h2></b>" +
                "&#8226; <b>Primaria: </b>Constituye la superficie  de agua de la instalaci&oacuten y deben ser siempre vigiladas sin interrupci&oacuten. Su observaci&oacuten es prioritaria, ya que es donde se producen los accidentes m&aacutes graves y donde, por definici&oacuten legal, trabaja el socorrista acu&aacutetico." +
                "<br>&#8226; <b>Secundaria: </b>Constituye la playa circundante a la superficie de agua, no precisa vigilancia constante, pero debe ser regularmente observada." +
                "<br>&#8226; <b>Terciaria: </b>son otras &aacutereas o dependencias de la instalaci&oacuten.  No es necesario vigilarlas pero se deben inspeccionar diariamente para detectar y eliminar posibles fuentes de accidente ( tanques de almacenamientos de agua, diques de desagüe etc)." +
                "<br><br><b>Formas de entrada al agua y acercamiento al accidentado: </b>" +
                "<br>&#8226; T&eacutecnica de agarre y zafa." +
                "<br>&#8226; Salvamento en profundidad" +
                "<br>&#8226; El s&iacutendrome de inmersi&oacuten." +
                "<br>&#8226; Sistemas de remolque." +
                "<br>&#8226; Formas de sacar al accidentado. En piscina. En medio natural acu&aacutetico." +
                "<br>&#8226; Material de seguridad y salvamento: Procedimientos y t&eacutecnicas con material de auxilio." +
                "<br>&#8226; Salvamento en instalaciones acu&aacuteticas y en zonas acu&aacuteticas naturales." +
                "<br>&#8226; T&eacutecnicas especificas de nado en el medio acu&aacutetico." +
                "<br>&#8226; Desplazamiento en el medio acu&aacutetico con niveles de resistencia y velocidad adecuados." +
                "<br><br><b>T&eacutecnicas de nataci&oacuten para rescate acu&aacutetico:</b>" +
                "<br>&#8226; Tener presente el HALEM (H:hablar, A:acercar, L:lanzar l&iacutenea, E:extraer, N:nadar)." +
                "<br>&#8226; Maniobras de entrada, aproximaci&oacuten, control y remolque en diferentes situaciones." +
                "<br>&#8226; Posici&oacuten del cuerpo." +
                "<br>&#8226; Ubicaci&oacuten con relaci&oacuten a la direcci&oacuten de la corriente." +
                "<br>&#8226; Acci&oacuten de brazos y piernas." +
                "<br>&#8226; Respiraci&oacuten." +
                "<br>&#8226; Coordinaci&oacuten." +
                "<br>&#8226; Nataci&oacuten con aletas.<br><br><hr>";

        String contenidoRescateAcuatico3="<br><br><b><h2>T&eacutecnicas de nataci&oacuten para rescate acu&aacutetico.</h2></b>" +
                "&#8226; Nataci&oacuten con equipo auxiliar de salvamento acu&aacutetico: chalecos, cascos, cinturones, flotadores, arneses, boyas, silbato y flotadores de otro tipo." +
                "<br>&#8226; Apoyo con lanchas y/o botes." +
                "<br>&#8226; Maniobra de extracci&oacuten del medio de un posible accidentado con seguridad y eficacia." +
                "<br>&#8226; Se&ntildeales universales de rescate acu&aacutetico." +
                "<br><br><b><h2>Principios generales del rescate acu&aacutetico</h2></b>" +
                "<br><b>1. Prevenci&oacuten: </b>" +
                "<br>Conjunto de preparativos que se disponen con anticipaci&oacuten para advertir, evitar e impedir un suceso o accidente mediante la educaci&oacuten, divulgaci&oacuten y servicio." +
                "<br><br><b>2. Vigilancia: </b>" +
                "<br>Es la labor continuada de observaci&oacuten, cuidado y atenci&oacuten del espacio en que se desarrolla la actividad, (piscina, instalaci&oacuten acu&aacutetica, r&iacuteo, embalse, playa. etc.), por medio de la cual el Rescatista informa a los usuarios, previene los problemas, percibe los accidentes, e inicia las acciones para resolver adecuadamente cualquier incidencia o accidente que pueda producirse." +
                "<br><b>Elementos psicol&oacutegicos de la vigilancia. </b>" +
                "<br>&#8226; Percepci&oacuten: por parte del Rescatista de lo que sucede (Visi&oacuten directa y Audici&oacuten)." +
                "<br>&#8226; Atenci&oacuten: situaci&oacuten de alerta durante todo el tiempo que dure su labor." +
                "<br>&#8226; Concentraci&oacuten: vigilar la zona de modo selectivo y excluyente." +
                "<br>&#8226; Motivaci&oacuten: sentirse respetado y valorado supone  un refuerzo adicional para realizar su labor." +
                "<br>&#8226; Intereses y valores: la observaci&oacuten a corto plazo se realiza en funci&oacuten de experiencias y formaci&oacuten pero a largo plazo son los intereses (base solidaria y altruista) del Socorrista." +
                "<br><br><b>3. Control: </b>" +
                "<br>El Rescatista debe dominar la situaci&oacuten en todo momento, no confiar en la improvisaci&oacuten. Conservar la serenidad y sangre fr&iacutea, pero con rapidez y eficacia. No se deben correr riesgos innecesarios." +
                "<br><b>Estrategias de control visual sobre la zona de ba&ntildeo: </b>" +
                "<br>- Vigilancia global: todos los Rescatistas vigilan la totalidad de la zona." +
                "<br>- Vigilancia por sectores: cada Rescatista  una zona (zonas contiguas superpuestas)." +
                "<br>- Vigilancia mixta" +
                "<br><br><b>Estrategias de observaci&oacuten: </b>" +
                "<br>Grupo de riesgo, Niveles de nado y por edades." +
                "<br><br><b></b>Sistema 10:20" +
                "<br>Observar todo en 10 segundos y llegar a cualquier zona en 20." +
                "<br><br><b>4.  Presteza: </b>" +
                "<br>Se define como la necesidad de reducir el tiempo de rescate. <br>No pensando en precipitaci&oacuten, nerviosismo o realizando las cosas sin pensar sino a la prontitud y brevedad en nuestras acciones, ejecut&aacutendolas siempre correcta y eficazmente, con habilidad y sin el menor riesgo para aquellas personas a las que se rescata." +
                "<br><br><b>5. Diagn&oacutestico y Actuaci&oacuten</b>" +
                "<br>&#8226; Diagn&oacutestico: Valorar la situaci&oacuten correctamente y tomar la decisi&oacuten. En el caso de una atenci&oacuten primaria, valorar el estado de la v&iacutectima y establecer el diagn&oacutestico descubriendo la causa del accidente." +
                "<br>&#8226; Actuaci&oacuten: Efectuar las t&eacutecnicas de remolque y extracci&oacuten del accidentado decididas. En su caso realizar las t&eacutecnicas de primeros auxilios necesarias.<br><br><hr>";

        String contenidoRescateAcuatico4="<br><br><b><h2></h2>Principios b&aacutesicos de cobertura</b>" +
                "<br>&#8226; Delimitar el periodo de cobertura: Durante este periodo se asegura la vigilancia; este debe ser conocido y expuesto p&uacuteblicamente, informando que fuera de el no existe responsabilidad y que el usuario utiliza la instalaci&oacuten bajo su propia responsabilidad, asumiendo el riesgo de no ser vigilado." +
                "<br>&#8226; Delimitar los limites de la zona: Adecu&aacutendola a la capacidad de la vigilancia y teniendo en cuenta el tama&ntildeo total de la instalaci&oacuten, el numero de usuarios y la actividades que en ella se realizan." +
                "<br><br><b>Recomendaciones Generales </b>" +
                "<br>&#8226; Conocer la zona de ba&ntildeo." +
                "<br>&#8226; No ba&ntildearse solo." +
                "<br>&#8226; M&oacutejate antes de entrar en el agua." +
                "<br>&#8226; Respeta las horas de digesti&oacuten." +
                "<br>&#8226; Vigila de cerca de ni&ntildeos y ancianos." +
                "<br>&#8226; Si ves a alguien en peligro pide ayuda." +
                "<br>&#8226; Si estas en peligro, conserva la calma." +
                "<br><br><b>Recomendaciones para los rescatistas.</b>" +
                "<br>&#8226; Los niveles altos de concentraci&oacuten  se pueden mantener 30-40 minutos." +
                "<br>&#8226; Ninguna zona debe quedar desprotegida en ning&uacuten momento." +
                "<br>&#8226; El Rescatista que vuelva de descansar  debe acudir al puesto de mayor saturaci&oacuten de gente o tiempo de vigilancia.<br><br><hr>";



        ArrayList<Respuestas>  respuestasRescateAcuatico = new ArrayList<Respuestas>();
        respuestasRescateAcuatico.add(new Respuestas("Perdida de visión", false));
        respuestasRescateAcuatico.add(new Respuestas("Dolor intenso en el &aacuterea afectada", true));
        respuestasRescateAcuatico.add(new Respuestas("P&eacuterdida de audici&oacuten", false));


        Preguntas preguntaRescateAcuatico = new Preguntas("S&iacutentomas de una fractura", respuestaHeridas);

        ArrayList<AtencionesEmergencias>  rescateAcuatico = new ArrayList<AtencionesEmergencias>();
        rescateAcuatico.add(new AtencionesEmergencias(R.drawable.imgrescateacuatico1,contenidoRescateAcuatico1, "Rescate Acuático", preguntaRescateAcuatico));
        rescateAcuatico.add(new AtencionesEmergencias(R.drawable.imgacuatico2,contenidoRescateAcuatico2, "Rescate Acuático", preguntaRescateAcuatico));
        rescateAcuatico.add(new AtencionesEmergencias(R.drawable.imgacuatico3,contenidoRescateAcuatico3, "Rescate Acuático", preguntaRescateAcuatico));
        rescateAcuatico.add(new AtencionesEmergencias(R.drawable.imgacuatico4,contenidoRescateAcuatico3, "Rescate Acuático", preguntaRescateAcuatico));


        //---------------------------------------------------------------------------------------------------------------------

        primerosAuxilios.add(new PrimerosAuxilios("Buscando que las comunidades sean más resilientes a los choques, factores de estrés y desastres.","Resiliencia Comunitaria", R.drawable.resilecinaicon, resiliencia));
        primerosAuxilios.add(new PrimerosAuxilios("¿Cómo debes actuar durante una emergencia?", "Primeros Auxilios Psicológicos ", R.drawable.inmo_icon, ayudaPsicologica));
        primerosAuxilios.add(new PrimerosAuxilios("Sistema de clasificación de víctimas.","Triajes", R.drawable.triageicon, triages));
        primerosAuxilios.add(new PrimerosAuxilios("Primeros auxilios para actuar durante una emergencia.","Atención de Heridas, Hemorragias y fracturas.", R.drawable.heridas_icon, fracHeridaHemo));
        primerosAuxilios.add(new PrimerosAuxilios("¿Cómo transportar personas lesionadas?","Transporte y camillaje.", R.drawable.camillajeicon, transporte));
        primerosAuxilios.add(new PrimerosAuxilios("¿Cómo actuar durante un rescate acuático?","Rescate acuático.", R.drawable.acuatico_icon, rescateAcuatico));
        primerosAuxilios.add(new PrimerosAuxilios("¿Cómo debes actuar durante una emergencia?", "Sistema de Manejo de Emergencias", R.drawable.manejo, comandosEmergencias));
    }


}
