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
                "<br><br>El contexto en el nivel de la comunidad está fortalecido y estandarizado, y el programa de evaluación del riesgo desarrollado e incorporado en el IPM." +
                "Las plantillas de proyecto y las herramientas desarrolladas para la construcción de intervenciones de desarrollo resiliente incorporados en las políticas de WV, sistemas y prácticas, incluyendo IPM de Guía de Orientación para el Programa Integrado." +
                "Mecanismos para el seguimiento de las vulnerabilidades, desarrollado y aplicado para medir la eficacia y adecuación de las intervenciones de desarrollo." +

                "<br><br><br><b>Objetivos de los Futuros preferidos 2.</b>" +
                "<br><br>Fortalecer los mecanismos de aprendizaje en la acción, la investigación empírica, documentación, análisis y difusión de las nuevas mejores prácticas a nivel comunitario para aumentar la resiliencia, la" +
                "DDR y el cambio climático." +

                "<br><br>Comunidades de Práctica movilizadas y activas en toda la organización fomentando la innovación, el intercambio, el aprendizaje y la promoción de CR / RRD y las mejoras prácticas en materia de cambio climático." +
                "Adaptado del proyecto de Resiliencia Comunitaria" +
                "Establecer un sistema de seguimiento para la gestión dinámica de la información y el contexto sobre el riesgo de desastres a nivel comunitario, nacional y regional para comprender mejor, mitigar el crecimiento de la vulnerabilidad y crisis pendientes." +
                "<br><br>Refuerzo de las capacidades y competencias en todos los niveles de construcción de la resiliencia, la DRR y la adaptación al cambio climático." +

                "<br><br><br><b>Objetivos de los Futuros preferidos 3.</b>" +
                "<br><br>Asociaciones productivas y colaborativas en el lugar con organizaciones externas y coaliciones claves que aumenten la resiliencia centrada en las prácticas de desarrollo a través de las industrias humanitarias y de desarrollo." +
                "<br><br>Abogar por y con los niños, el fortalecimiento de su participación en el proceso de la DDR y la promoción de su papel como agentes de cambio." +
                "<br><br>Asociaciones de en el lugar con las principales instituciones académicas para fortalecer nuestra capacidad de investigación y recopilación de pruebas.";

        String contenidoResiliencia2="<br><br><p align=\"justify\">Según la comunidad de Práctica de Visión Mundial (VM), Resiliencia Comunitaria es la capacidad que tiene una comunidad para:" +

                "<br>&#8226; Amortiguar el estrés o las fuerzas destructivas a través de la resistencia o adaptación." +
                "<br>&#8226; Manejar o mantener las funciones y las estructuras básicas durante el impacto o el desastre." +
                "<br>&#8226; Recuperarse después del impacto o desastre." +

                "<br><br>Visión Mundial busca alcanzar la Resiliencia Comunitaria posicionándola como uno de los seis objetivos fundamentales de su trabajo. Este objetivo específicamente plantea apoyar a las comunidades para contrarrestar los riesgos, mitigar los impactos, y disminuir las vulnerabilidades y la injusticia que ellas y sus niños y niñas enfrentan." +
                "<br><br>Uno de los indicadores de Desarrollo" +
                "<br><br>Transformador (IDTs) de Visión Mundial pretende medir la resiliencia de hogar. La del hogar es una estrategia de supervivencia adaptativa, tal y como lo es la venta de un recurso productivo para mitigar los impactos externos y/o factores de estrés ambiental con el fin de suplir las necesidades básicas del hogar." +

                "<br><br><b><h2>¿Por qué es importante la Resiliencia Comunitaria?</h2></b>" +
                "<br>Cada dólar invertido en la reducción de riesgos de desastres (RRD) es el equivalente de entre cinco a diez dólares en la respuesta a un desastre." +
                "<br><br>La fatiga institucional está sobrecargada a las agencias humanitarias internacionales que responden a los desastres naturales y humanos. Se requiere una mayor atención en iniciativas de reducción del riesgo para aliviar esta carga." +
                "Invertir en la reducción de riesgos de desastres contribuye directamente al éxito de los Objetivos de Desarrollo del Milenio" +
                "(ODM)." +
                "<br><br>Se anticipa que los desastres de arremetida lenta, provocados por la inseguridad alimentaria y los cambios climáticos, aumentaran en los próximos años lo cual tiene una alta probabilidad de contribuir significativamente a la inestabilidad de las comunidades que viven bajo la línea de la pobreza.</p>" +

                "<br><br><b><h2>¿Cuándo se aplica la Resiliencia Comunitaria?</h2></b>" +
                "<br><b>Antes: </b>" +
                "<br>Para evitar el impacto, el estrés o el desastre completo (prevención o “resiliencia”)." +
                "<br><br><b>Durante: </b>" +
                "<br>Para resistir a el efecto de un impacto, estrés o desastre (absorción o “repuesta adaptiva)." +
                "<br><br><b>Después: </b>" +
                "<br>Para recuperar rápidamente de un impacto, un factor de estrés o desastre (la habilidad de recuperarse o repeler).<br><br>";

        String contenidoResiliencia3="<br><br>Según el Modelo de Programas Integrales (IPM), la resiliencia se aplica a los países del Contexto I (alto nivel de necesidades / bajo nivel de estabilidad) hasta los del Contexto V (nivel de necesidades relativamente bajo / al nivel de estabilidad económica)." +
                "<br><br><b><h2>¿A quiénes se enfoca la resiliencia comunitaria en la región de América Latina y el Caribe?</h2></b>" +
                "<br>Una red regional de 5.8 millones de niñas, niños, adolescentes y jóvenes y sus comunidades." +

                "<br><br><b><h2>¿Quién? = Prácticas en Desarrollo Resiliente</h2></b>" +
                "<br><b>Meta del Proyecto: </b>Apoyar el bienestar sostenido de los niños, niñas, adolescentes, jóvenes y sus comunidades a través de transversalizar y engrandecer al escala de PDR como una parte integral de programación de desarrollo en la Región de América Latina y el Caribe." +
                "<br><br><b>Futuros preferidos 1.</b>" +
                "<br>La programación a nivel comunitario, nacional, regional y mundial se verá reforzada por los enfoques y estrategias de adaptación que reducen eficazmente el riesgo de desastres y los impactos del cambio climático y construir comunidades resistentes, de manera que los beneficios del desarrollo se mantienen y se añade a la forma sostenible para las generaciones futuras." +
                "<br><br><b>Futuros preferidos 2.</b>" +
                "<br>La capacidad de adaptación y sistemas de organización se hacen operativos para proporcionar el desarrollo profesional y la práctica del cambio estratégico que sigue siendo sensible al ambiente externo." +
                "<br><br><b>Futuros preferidos 3.</b>" +
                "<br>Las alianzas estratégicas están en el lugar donde aumenten la resistencia de prácticas de desarrollo a nivel mundial, y que influyen en la elaboración de políticas macro que proteger a las personas por lo que no están en riesgo y se mueven las corrientes de características innovadoras para crear un entorno propicio para efectivo y sostenibilidad de los beneficios del desarrollo." +

                "<br><br><b><h2>¿Cómo se aplica la Resiliencia Comunitaria por el PRC LACRO?</h2></b>" +
                "<br>Los capitales de medios de vida sostenible valorados son: Humano-cultural, físico-infraestructura y espiritual- psicológico. Los temas de Marco de Acción Hyogo" +
                "(MAH) son: la gobernanza; la evaluación de riesgos, monitoreo y alerta; conocimiento y educación; factores de riesgo subyacentes; y preparación y respuesta a desastres. Los temas transversales claves en asoció con el MAH son: el género, protección de la niñez, discapacidades," +
                "VIH/SIDA/Salud, y el apoyo voluntario." +
                "<br><br><b>Análisis del punto crítico</b>" +
                "<br>Al utilizar el análisis del árbol de problemas, las comunidades participantes toman en consideración siete áreas temáticas de vidas resilientes / medios de vida sostenible y cinco áreas temáticas del" +
                "Marco de Acción de Hyogo (junto con los temas multidisciplinarios), para identificar la raíz de la(s) causa(s) primaria(s) de vulnerabilidad y de amenazas en las comunidades que podrían llevarles a puntos críticos negativos y conversamente determinar las fuentes de factores protectivos que las llevaran a un punto crítico positivo y la resiliencia.";











        ArrayList<Respuestas>  respuestaResiliencia = new ArrayList<Respuestas>();
        respuestaResiliencia.add(new Respuestas("Perdida de visión", false));
        respuestaResiliencia.add(new Respuestas("Dolor intenso en el área afectada", true));
        respuestaResiliencia.add(new Respuestas("Pérdida de audición", false));


        Preguntas preguntaResiliencia = new Preguntas("Síntomas de una fractura", respuestaResiliencia);

        ArrayList<AtencionesEmergencias>  resiliencia = new ArrayList<AtencionesEmergencias>();
        resiliencia.add(new AtencionesEmergencias(R.drawable.resiliencia, contenidoResiliencia1, "Descripción general", preguntaResiliencia));
        resiliencia.add(new AtencionesEmergencias(R.drawable.fractura1, contenidoResiliencia2, "¿Qué es Resiliencia Comunitaria?", preguntaResiliencia));
        resiliencia.add(new AtencionesEmergencias(R.drawable.resiliencia, contenidoResiliencia3, "¿Dónde se aplica?", preguntaResiliencia));


        //Primeros auxilios psicologicos.---------------------------------------------------------------------------

        String psicologico1="<br><br>Cuando las personas se enfrentan a  crisis severas derivadas de situaciones vinculadas a desastres naturales o " +
                "producidos por el hombre o ambos, se busca la manera de actuar y tomar mejores decisiones. " +
                "La Psicología de la Emergencia además de auxiliar y guiar a los involucrados para aliviar su sufrimiento procura sobre todo la " +
                "supervivencia y la disminución  máxima de los daños" +

                "<br><br><b>¿Cómo afectan las situaciones de crisis a las personas?</b><br>" +
                "&#8226; La naturaleza y gravedad del /  de los acontecimientos que experimentan.<br>" +
                "&#8226; Su experiencia con acontecimientos angustiantes anteriores.<br>" +
                "&#8226; El apoyo de otras personas en su vida.<br>" +
                "&#8226; Su historia personal y familiar de  problemas de salud mental.<br>" +
                "&#8226; Su cultura y tradiciones.<br>" +
                "&#8226; Su edad(por ejemplo, los niños de diferentes edades reaccionan de distintas maneras.)<br>" +

                "<br><br><b>¿Qué es la primera ayuda psicológica?</b><br>" +
                "Según ESFERA (2011) y IASC (2007), la primera ayuda psicológica (PAP) describe una respuesta humana, de apoyo a otros " +
                "seres humanos que están sufriendo y que pueden necesitar ayuda. " +
                "<br><br><b>La PAP trata los siguientes temas: </b><br>" +
                "&#8226; Brindar ayuda y apoyo práctico de manera no invasiva <br>" +
                "&#8226; Evaluar las necesidades y preocupaciones.<br>" +
                "&#8226; Ayuda a las personas a atender sus necesidades básicas.<br>" +
                "&#8226; Escuchar a las personas, pero no presionarlas para que hablen<br>" +
                "&#8226; Reconfortar a las personas y ayudarlas a sentirse calmadas.<br><br>";

        String psicologico2="<br><br><b>¿Quién, Cuándo y Dónde?</b><br>" +
                "La PAP está dirigido a personas angustiadas afectadas recientemente por un acontecimiento crítico grave. " +
                "Se puede proporcionar ayuda tanto a niños como a adultos. Sin embargo, no todos los que experimentan una situación de crisis " +
                "necesitarán o querrán PAP. No se debe forzar la ayuda en aquellos que no la quieren, sino estar disponible para aquellos que puedan desear apoyo." +

                "<br><br><b>Personas que necesitan mayor apoyo experto inmediato: </b><br>" +
                "&#8226; Personas con lesiones graves que ponen en riesgo la vida y que necesitan atención médica urgente.<br>" +
                "&#8226; Personas que están alteradas que no pueden ocuparse de sí mismas o de sus hijos.<br>" +
                "&#8226; Personas que pueden hacerse daños a sí mismas o a otros." +

                "<br><br><b>¿Cuándo se proporciona la primera ayuda psicológica?</b><br>" +
                "&#8226; Puede facilitar PAP tan pronto como establezca contacto con personas que están en situaciones de angustia.<br>" +
                "&#8226; Normalmente  esto será durante o inmediatamente después del acontecimiento. Sin embargo, a veces puede ser días o semanas después " +
                "del acontecimiento dependiendo de cuánto ha durado o grave ha sido el acontecimiento." +

                "<br><br><b>¿Dónde se puede proporcionar primera ayuda psicológica?</b><br>" +
                "Lo ideal sería proporcionar PAP en un lugar donde exista cierta privacidad para hablar con la persona cuando se considere oportuno. " +
                "Para personas expuestas a ciertos tipos de acontecimiento críticos, como violencia sexual, la privacidad es esencial para la  confidencialidad " +
                "y el respeto de la dignidad de la persona.";

        String psicologico3="<br><br><b>La ayuda responsable requiere cuatro aspectos principales:</b><br> " +
                "&#8226; Respetar la seguridad, la dignidad y los derechos.<br>" +
                "&#8226; Adaptar la propia acción a la cultura de las personas.<br>" +
                "&#8226; Considerar otras medidas de respuesta a la emergencia.<br>" +
                "&#8226; Cuidarse a uno mismo." +

                "<br><br><b>¿Qué hacer?</b><br>" +
                "&#8226; Sea honrado y digno de confianza.<br>" +
                "&#8226; Respete el derecho de la gente a tomar sus propias decisiones.<br>" +
                "&#8226; Sea consciente  de sus propios prejuicios preferencias, y manténgalos al margen.<br>" +
                "&#8226; Deje claro a la gente que incluso si rechazan la ayuda ahora, podrá recibirla en el futuro.<br>" +
                "&#8226; Respete la privacidad y mantenga la historia de la persona confidencial, salvo imperativos.<br>" +
                "&#8226; Compórtese de forma adecuada teniendo en cuenta la cultura, edad y género de la persona" +

                "<br><br><b>¿Qué no hacer?</b><br>" +
                "&#8226; No se aproveche de su relación que ayuda.<br>" +
                "&#8226; No pida a la persona dinero o favores a cambio de ayudarle.<br>" +
                "&#8226; No haga falsas promesas o provea información no contrastada.<br>" +
                "&#8226; No exagere sus habilidades.<br>" +
                "&#8226; No fuerce ayuda en la gente, y no sea entrometido o prepotente.<br>" +
                "&#8226; No presione a la gente para que le cuente su historia.<br>" +
                "&#8226; No comparta la historia de una persona con otras personas.<br>" +
                "&#8226; No juzgue a la persona por sus acciones o sentimiento." +

                "<br><br><b>Siempre que sea posible en respuesta a una situación de crisis: </b><br>" +
                "&#8226; Siga las indicaciones de las autoridades competentes a cargo de la gestión de la crisis.<br>" +
                "&#8226; Infórmese de las respuestas de emergencia  que están organizando, y de los recursos disponibles" +
                "si existieran para ayudar a las personas.<br>" +
                "&#8226; No estorbe al personal de búsqueda y rescate o al personal médico de emergencia.<br>" +
                "&#8226; Sea consciente  de su rol, y de los límites de su rol.<br><br>";

        String psicologico4="<br><b>Comunicación adecuada</b><br>" +
                "Mantener la calma y demostrar comprensión puede ayudar a que las personas angustiadas se sientan más seguras y  a salvo, comprendida, respetada y atendida de forma apropiada." +
                "<br><br><b>Lo que debemos hacer y decir: </b><br>" +
                "&#8226; Dé la información de un modo en que la persona la pueda atender, es decir de formas simples.<br>" +
                "&#8226; Hágale saber que comprende, cómo se sienten y que lamenta sus pérdidas y lo que les ha pasado, como haberse quedad sin hogar " +
                "o haber perdido un ser querido.<br>" +
                "&#8226; Hágale saber que reconoce sus fortalezas y la manera en que están ayudando a sí mismos.<br>" +
                "&#8226; Deje espacios para el silencio.<br>" +

                "<br><b>Lo que NO debemos hacer y decir.</b>" +
                "<br>&#8226; No presione a la persona para que cuente su historia." +
                "<br>&#8226; No interrumpa ni apure a las personas mientras cuenta su historia (por ejemplo, no mire la hora, ni hable demasiado rápido)." +
                "<br>&#8226; No toque a la persona si no está seguro de que sea apropiado." +
                "<br>&#8226; No juzgue lo que hayan hecho o dejado de hacer ni sus sentimientos." +
                "<br>&#8226; No invente cosas que no sabe." +
                "<br>&#8226; No utilice expresiones demasiado técnicas. " +
                "<br>&#8226; No cuente la historia de otra persona." +

                "<br><br><b>Antes de acudir al sitio de la crisis, informarse acerca de lo siguiente.</b>" +
                "<br>&#8226; La situación de crisis." +
                "<br>&#8226; Servicios y apoyo disponible." +
                "<br>&#8226; Cuestiones de seguridad" +

                "<br><br><b>Principios de actuación de la primera ayuda psicológica.</b>" +
                "<br>Observar, Escuchar y conectar."+

                "<br><br><b>Brinde información</b><br>" +
                "<br><b>Las personas afectadas por una situación de crisis querrán información sobre:</b><br>" +
                "&#8226; Lo sucedido.<br>" +
                "&#8226; La situación de sus seres queridos y de otros que han sido afectados. <br>" +
                "&#8226; Su seguridad.<br>" +
                "&#8226; Sus derechos.<br>" +
                "&#8226; Cómo acceder a los servicios y cosas en general que necesitan." +

                "<br><br><b>Crisis y espiritualidad</b>" +
                "<br>&#8226; Conozca y respete el trasfondo religioso de la persona." +
                "<br>&#8226; Pregúntele qué le suele ayudar a sentirse mejor, animarle a que haga cosas que ayuden a sobrellevar la situación, incluidas prácticas espirituales si la persona las menciona." +
                "<br>&#8226; Escuche respetuosamente y sin juzgar las creencias espirituales o las preguntas que la persona pueda hacerse." +

                "<br><br><b>Prepárese a ayudar</b><br>" +
                "&#8226; Infórmese sobre situaciones de crisis, y las funciones y responsabilidades de los diferentes tipos de personas que están ofreciendo ayuda.<br>" +
                "&#8226; Tenga en cuenta su propia salud.<br>" +
                "&#8226; Decida sinceramente si está o no preparado para ayudar en esta situación determinada de crisis y en este momento concreto. <br><br>";


        ArrayList<Respuestas>  respuestasPap = new ArrayList<Respuestas>();
        respuestasPap.add(new Respuestas("Juzgar a la persona por sus acciones o sentimiento.", false));
        respuestasPap.add(new Respuestas("Compartir la historia de una persona con otras personas.", false));
        respuestasPap.add(new Respuestas("Respetar el derecho de la gente a tomar sus propias desiciones.", true));


        Preguntas preguntaPap = new Preguntas("¿Qué hacer en una ayuda Psicológica?", respuestasPap);

        ArrayList<AtencionesEmergencias>  ayudaPsicologica = new ArrayList<AtencionesEmergencias>();
        ayudaPsicologica.add(new AtencionesEmergencias(R.drawable.psicologico1,psicologico1, "Ayuda Psicológicas", preguntaPap));
        ayudaPsicologica.add(new AtencionesEmergencias(R.drawable.ayuda_psicologica2, psicologico2, "", preguntaPap));
        ayudaPsicologica.add(new AtencionesEmergencias(R.drawable.ayuda_psicologica3, psicologico3, "", preguntaPap));
        ayudaPsicologica.add(new AtencionesEmergencias(R.drawable.ayuda_psicologica4, psicologico4, "Comunicación adecuada", preguntaPap));

        //-------------------------------------Manejo de emergencias-----------------------------------------------------------------

        String manejo1="<br><br>Es una herramienta de gestión estandarizada para atender las demandas en situaciones de emergencias y/o de no emergencia.<br>" +
                "&#8226; Representa las mejores prácticas en el tema y ha sido adoptada como el estándar para la gestión de las emergencias en forma global." +

                "<br><br><b>¿Dónde puedo aplicar?</b><br>" +
                "El sistema de manejo de emergencia busca que bomberos estructurales, forestales, aeronáuticos, policía y otros grupos trabajen bajo un mismo sistema, empleando la misma terminología común con una organización definida y regida por procedimientos estandarizados. " +
                "En la medida en que las  instituciones aplican estos procedimientos estandarizados en la atención de incidentes cotidianos, pequeños y fáciles de solucionar; mejoran su preparación para trabajar con el sistema en incidentes de gran magnitud. " +
                "<br><br><b>El SCI  se puede aplicar en: </b><br>" +
                "&#8226; Derrumbes, explosiones, inundaciones, terremotos, huracanes, erupciones volcánicas y tornados.<br>" +
                "&#8226; Incendios forestales, estructurales, industriales y aeronáuticos.<br>" +
                "&#8226; Accidentes de transporte aéreo, ferroviario, acuático o terrestre.<br>" +
                "&#8226; Accidentes domésticos, vehiculares e industriales.<br>" +
                "&#8226; Misiones de búsqueda y operaciones de rescate.<br>" +
                "&#8226; Incidentes con materiales peligrosos.<br>" +
                "&#8226; Respuesta a derrames de petróleo.<br>" +
                "&#8226; Eventos planificados ejemplo: Desfiles, celebraciones, conciertos, plazas públicas.<br><br>";


        String manejo2="<br><br><b>Principios del sistema de manejo de emergencias.</b><br>" +
                "El SCI se basa en principios que permiten asegurar el despliegue rápido, coordinado y efectivo de los recursos y minimizar la alteración de las políticas y procedimientos operativos propio de cada una de las instituciones que responden\n" +
                "<br><br><b>Esos principios son:</b><br>" +
                "&#8226; Terminología común.<br>" +
                "&#8226; Alcance de control.<br>" +
                "&#8226; Organización modular.<br>" +
                "&#8226; Comunicaciones integradas.<br>" +
                "&#8226; Consolidación de planes en un plan de acción del incidente (PAI).<br>" +
                "&#8226; Unidad de mano.<br>" +
                "&#8226; Comando unificado. <br>" +
                "&#8226; Instalaciones con ubicación determinada y denominación precisa.<br>" +
                "&#8226; Manejo integral de los recursos.<br>" +

                "<br><br><b>Estructura y funciones del sistema</b><br>" +
                "Cuando en un sistema se necesita el esfuerzo de diferentes instituciones, cualquiera sea la magnitud o " +
                "complejidad del mismo o el número de instituciones participantes, se requiere un trabajo coordinado para " +
                "asegurar una respuesta efectiva mediante el uso eficiente y seguro de los recursos.<br><br>";

        String manejo3="<br><br><b>El sistema de manejo de emergencias está basado en ocho (8) funciones:</b><br>" +
                "&#8226; Mando.<br>" +
                "&#8226; Planificación.<br>" +
                "&#8226; Operaciones.<br>" +
                "&#8226; Logística.<br>" +
                "&#8226; Administración y finanzas.<br>" +
                "&#8226; Seguridad.<br>" +
                "&#8226; Información pública.<br>" +
                "&#8226; Enlace." +

                "<br><br><b>Manejo por objetivos</b><br>" +
                "En el manejo de incidentes, los objetivos respecto a las siguientes prioridades: <br>" +
                "&#8226; Salvamento de vidas.<br>" +
                "&#8226; Estabilización de incidentes.<br>" +
                "&#8226; Reservación de la prioridad. <br>" +

                "<br><br><b>Establecimiento y transferencias del comando</b><br>" +
                "La función del comando debe establecerse claramente al comienzo de las operaciones de respuestas al incidente. Cuando el comando es " +
                "transferido de una organización o persona a otra, la transferencia debe incluir un periodo de transición donde habrá una superposición para garantizar que la transferencia se dé sin inconvenientes y que no se pierda información importante al realizar el cambio." +

                "<br><br><b>La transferencia del comando se da cuando:</b><br>" +
                "&#8226; Una persona más calificada asume el mando.<br>" +
                "&#8226; La situación del incidente cambia con el tiempo y en consecuencia la ley exige el cambio de comando.<br>" +
                "&#8226; Hay una cambio normal de personal en incidentes prolongados.<br>" +
                "&#8226; La respuesta al incidente concluye y la responsabilidad es transferida al organismo de origen.";

        String manejo4="<br><br><b>Despliegue</b><br>" +
                "El personal y el equipo deben responder solo cuando lo solicite o lo disponga la autoridad correspondiente. " +
                "Evadir los procedimientos establecidos de despliegue solo genera más confusión." +

                "<br><br><b>Comando unificado</b><br>" +
                "El comando unificado es una estructura que permite que todos los organismos de respuesta trabajen en conjunto, " +
                "compartiendo objetivos y recursos, sin comprometer la autoridad ni la responsabilidad de organismo individual. " +
                "La organización sin fines de lucro trabajan a través de una estructura de comando unificado que opera como apoyo, " +
                "al manejo de emergencias, los funcionarios del gobierno y otros trabajadores de respuestas designados." +

                "<br><br><b>Formación de equipos</b><br>" +
                "Haz que cada miembro del equipo exponga sus habilidades y experiencias, luego: <br>" +
                "&#8226; Elija la posición de ICS para la que estén más calificados.<br>" +
                "&#8226; Cada persona del equipo debe cubrir al menos una posición de ICS.<br>" +
                "&#8226; Una vez hallas elegido a una persona para cubrir cada rol, haz que pongan frente a ellos “el identificador de posiciones ICS”" +

                "<br><br><b>Descripción de las funciones: comando de incidentes</b><br>" +
                "&#8226; Establece objetivos, estrategias y prioridades en el incidente.<br>" +
                "&#8226; Asume toda la responsabilidad por el incidente." +

                "<br><br><b>Operaciones</b><br>" +
                "&#8226; Define tácticas y recursos para alcanzar los objetivos.<br>" +
                "&#8226; Dirige la respuesta táctica “alimentación”, atención médica, remoción de escombros, etc.<br>" +

                "<br><br><b>Planificación</b><br>" +
                "&#8226; Recolecta, analiza y evalúa información.<br>" +
                "&#8226; Gestiona recursos, decide las necesidades para la alimentación y distribución masiva.<br>" +
                "&#8226; Mantiene la documentación “registro”." +

                "<br><br><b>Logística</b><br>" +
                "&#8226; Provee recursos y servicios necesarios (PODS).<br>" +

                "<br><br><b>Financiero administrativo</b><br>" +
                "&#8226; Rendición de cuentas para gastos, reclamos y compensatorio.<br>" +
                "&#8226; Provee los recursos necesarios. <br>";


        ArrayList<Respuestas>  respuestasComandos= new ArrayList<Respuestas>();
        respuestasComandos.add(new Respuestas("Seguridad.", true));
        respuestasComandos.add(new Respuestas("Ingresos.", false));
        respuestasComandos.add(new Respuestas("Salud.", false));


        Preguntas preguntaComando = new Preguntas("Una función del sistema de manejo de emergencias.", respuestasComandos);

        ArrayList<AtencionesEmergencias>  comandosEmergencias = new ArrayList<AtencionesEmergencias>();
        comandosEmergencias.add(new AtencionesEmergencias(R.drawable.manejo_emergencia1,manejo1, "Manejo de Emergencias", preguntaComando));
        comandosEmergencias.add(new AtencionesEmergencias(R.drawable.manejo_emergencia1,manejo2, "", preguntaComando));
        comandosEmergencias.add(new AtencionesEmergencias(R.drawable.manejo_emergencia1,manejo3, "", preguntaComando));
        comandosEmergencias.add(new AtencionesEmergencias(R.drawable.manejo_emergencia1,manejo4, "", preguntaComando));


 //-----------------------Triage---------------------------------------------------------------------------------------------
        String contenidoTriage1="<br><br>Triaje procede de la palabra francesa triage que significa clasificar y es el conjunto de procedimientos mediante el cual se hace una revisión y clasificación de víctimas cuando su número excede los recursos disponibles de atención inmediata para establecer prioridades en atención y evacuación. " +
                "La persona a cargo de triaje debe estar en la capacidad de realizar un reconocimiento rápido de los pacientes, tomar decisiones inmediatas y realizar un etiquetado ágil y preciso; en la medida de lo posible debe tener experiencia y entrenamientos previos para lograr mayor precisión y exactitud." +

                "<br><br><b>Objetivos del triaje.</b>" +
                "<br>" +
                "<br>&#8226; Asistencia temprana." +
                "<br>&#8226; Aplicación de maniobras salvadoras." +
                "<br>&#8226; Determinar grado de urgencia." +
                "<br>&#8226; Documentar a los pacientes. " +
                "<br>&#8226; Controlar flujo de víctimas." +
                "<br>&#8226; Asignar áreas de atención." +
                "<br>&#8226; Distribuir al personal por áreas asistenciales." +
                "<br>&#8226; Iniciar medidas diagnósticas." +
                "<br>&#8226; Iniciar prehospitalarias." +
                "<br>&#8226; Control temprano de infecciones." +
                "<br>&#8226; Preparar la atención al público." +
                "<br>&#8226; Atención a los familiares." +

                "<br><br>Con la finalidad de hacer más objetivos los sistemas, internacionalmente se ha adoptado un código de colores que, independientemente del sistema, dividirá a los pacientes en cuatro categorías:" +
                "<br>&#8226; <b>ROJO: </b>Pacientes que precisan asistencia inmediata y una vez proporcionada son recuperables, es decir, tienen pronóstico aceptable." +
                "<br>&#8226; <b>AMARILLO: </b>Pacientes que precisan asistencia hospitalaria, pero que se puede esperar para realizar la evacuación. Precisan unos cuidados mínimos previos a la misma."+
                "<br>&#8226; <b>VERDE: </b>Pacientes que no precisan asistencia hospitalaria médica inmediata, o en todo caso pueden ser trasladados en vehículos no sanitarios. Su atención puede demorarse más de 6 horas."+
                "<br>&#8226; <b>NEGRO: </b>Este color se utiliza para aquellas personas fallecidas, por lo cual no amerita traslado ni asistencia hospitalaria.";

        String contenidoTriage2="<br><br><b>1- Escena I: </b>Observe atentamente el lugar en donde ocurrió la emergencia, para corroborar que es segura para acercarse y brindar ayuda. " +
                "Si hay personas cercas del accidente pregunte como sucedió y solicite que llamen a la Cruz Roja y Bomberos." +
                "<br><br><b>2- Clasificación de personas leves (color verde): </b>Observe atentamente a las personas y oriente que las personas que puedan caminar se alejen del lugar del accidente y se ubiquen en una zona más segura. A estas personas deberá entregarles la tarjeta con la clasificación verde." +
                "<br><br><b>3- Clasificación de personas heridas leves (color amarillo):  </b>Observe y examine atentamente a las personas y pregunte a cada herido como se llama, sabe que sucedió y como está; esto con el objetivo de valorar su estado de conciencia." +
                "<br><br><b>Criterios para colocar la tarjeta con la clasificación Amarilla: </b>" +
                "<br>&#8226; Heridas grandes no hemorrágicas. " +
                "<br>&#8226; Heridas articulares profundas." +
                "<br>&#8226; Quemaduras de 2° y 3° entre el 10% y 30%." +
                "<br>&#8226; Alergias con manifestaciones cutáneas." +
                "<br>&#8226; Fractura de huesos largos cerradas y huesos cortos abierta." +
                "<br>&#8226; Luxaciones de gran articulación sin compromiso." +
                "<br>&#8226; Lesiones en los ojos graves no penetrantes." +
                "<br>&#8226; Traumatismo torácico y abdominal sin compromisos." +
                "<br>&#8226; Obedece órdenes sencillas." +

                "<br><br><b>4- Clasificación de personas de atención inmediatas (Roja): </b>Observe y examine atentamente al herido y pregunte como se llama, sabe que sucedió y como está; esto con el objetivo de valorar su estado de conciencia." +
                "<br><br><b>Criterios para colocar la tarjeta con la clasificación Roja:</b>" +
                "<br>&#8226; No camina." +
                "<br>&#8226; Inconsciente." +
                "<br>&#8226; Heridas grandes hemorrágicas." +
                "<br>&#8226; Quemaduras de 2° y 3° entre el 31% y 50% en cara y mano." +
                "<br>&#8226; Fractura de huesos largos abiertas." +
                "<br>&#8226; Luxaciones de grandes articulaciones con compromiso." +
                "<br>&#8226; Lesiones en los ojos graves penetrantes." +
                "<br>&#8226; Hipotermia." +
                "<br>&#8226; Traumatismos torácicos y abdominales graves." +

                "<br><br><b>5- Clasificación de personas Muertas/ no recuperables (Negra): </b>" +
                "Observe y examine atentamente al herido y pregunte como se llama, sabe que sucedió y como esta; esto con el objetivo de valorar su estado de conciencia." +
                "<br><br><b>Criterios para colocar la tarjeta con la clasificación Roja:</b>" +
                "<br>&#8226; No camina." +
                "<br>&#8226; No respira." +
                "<br>&#8226; Alineación de vías áreas sigue sin respirar." +
                "<br>&#8226; No responde (Muerte).";

        String contenidoTriage3="<br><br><b><h2>Persona ideal para realizar el triaje</h2></b>" +
                "<br>&#8226; Que sea un facultativo experto en emergencias médicas con gran sentido clínico." +
                "<br>&#8226; Con formación multidisciplinaria y cualidades persona-les que abarquen desde las dotes de mando a la serenidad, la capacidad de organización y hasta imaginación." +
                "<br><br><b>Reglas del triaje:</b>" +
                "<br>&#8226; Rápido." +
                "<br>&#8226; Completo" +
                "<br>&#8226; Preciso y seguro." +
                "<br>&#8226; retrasar atención de victimas que esperan." +
                "<br>&#8226; No retener a los ya clasificados." +
                "<br>&#8226; 30 segundos para clasificar un muerto." +
                "<br>&#8226; 1 min. Para clasificar un herido leve." +
                "<br>&#8226; Ninguna víctima debe ser evacuada sin ser clasificada" +
                "<br>&#8226; Ante la duda de clasificar una víctima, hacerlo siempre en la categoría superior." +
                "<br>&#8226; Excepciones: " +
                "             - Oscuridad." +
                "             - Malas condiciones meteorológicas." +
                "             - Riesgo potencial." +
                "<br><br><b>Métodos de clasificación.</b>" +
                "<br>&#8226; METTAG" +
                "<br>&#8226; S.T.A.R.T" +
                "<br>&#8226; S.H.O.R.T<br><br>";


        ArrayList<Respuestas>  respuestasTriage= new ArrayList<Respuestas>();
        respuestasComandos.add(new Respuestas("Seguridad.", true));
        respuestasComandos.add(new Respuestas("Ingresos.", false));
        respuestasComandos.add(new Respuestas("Salud.", false));


        Preguntas preguntaTriage = new Preguntas("Una función del sistema de manejo de emergencias.", respuestasTriage);

        ArrayList<AtencionesEmergencias>  triages = new ArrayList<AtencionesEmergencias>();
        triages.add(new AtencionesEmergencias(R.drawable.imgtriaje1,contenidoTriage1, "Triaje.", preguntaTriage));
        triages.add(new AtencionesEmergencias(R.drawable.imgtriaje2, contenidoTriage2, "¿Cómo aplicar start?", preguntaTriage));
        triages.add(new AtencionesEmergencias(R.drawable.imgtriaje3,contenidoTriage3, "", preguntaTriage));





        //-------------------------------Fracturas-Heridas-Hemorragias--------------------------------------------------

        String herida1="<br><br>Es la separación de los tejidos de la piel, que puede dejar al descubierto otras partes del cuerpo como los huesos y otros órganos del ser humano que se encuentran internamente."
        + "<br><br><b>Elementos que pueden producir una herida</b><br>" +
                "&#8226; <b>Cortantes :</b> Bordes rectilíneos (cuchillo, gillette, navaja).<br>" +
                "&#8226; <b>Lacerantes :</b> Bordes irregulares (latón, sierra, vidrio).<br>" +
                "&#8226; <b>Punzantes:</b> Orificio a veces con salida (punzón, clavos, agujas).<br>" +
                "&#8226; <b>Contusas:</b> Golpes fuertes (pedradas, martillazos).<br>" +
                "&#8226; <b>Corto Punzante:</b> Bordes rectilíneos  y orificio (verruguilla, navaja).<br>" +
                "&#8226; <b>Avulsiva:</b> Desgarre o pérdida de un miembro o parte del cuerpo.<br><br>";

        String hemorragea1="<br><br>Es la pérdida abundante de sangre al romperse un vaso sanguíneo" +
                "<br><br><b>Tipos de hemorragias: </b><br>" +
                "&#8226; Hemorragia Arterial: Sangre de color rojo que sale de forma intermitente coincidiendo con los latidos del corazón.<br>" +
                "&#8226; Hemorragias Venosas: Sangre de color oscuro y que sale de forma continua.<br>" +
                "&#8226; Hemorragia Capilar: Sangrado de color  rojo que sale de forma lenta.<br>" +

                "<br><br><b>Clasificación  de las Hemorragias: </b><br>" +
                "&#8226; Hemorragia Externa: Se acompaña de una herida en la piel y se observa salida de sangre hacia afuera.<br>" +
                "&#8226; Hemorragia Interna: El sangrado es interno. Este sangrado puede salir por los orificios naturales del cuerpo, convirtiéndose  en hemorragia  exteriorizada.<br>"+

                "<br><br><b><h2>Primeros auxilios para hemorragias</h2></b>"+
                 "<br>&#8226; <b>Haga  presión directa:</b> Use guantes y ejerza presión sobre la herida.<br>" +
                "&#8226; <b>Elevación:</b> Elevar las extremidades afectadas (piernas o brazos), para aminorar la salida de sangre al sitio de la herida. Si no existen fracturas u objetos ensartados  se elevan las extremidades afectadas a un nivel más alto que el del corazón.<br>" +
                "&#8226; <b>Presión Indirecta:</b> Usando la yema de los dedos, la palma de la mano, se apretará en el sitio afectado donde podamos prensar la arteria por donde sale la sangre contra el hueso, a fin de evitar el paso de la sangre.<br>";

        String contenidoFractura1="<br><br>Es la ruptura parcial o total de un hueso, causadas por factores externos o internos como enfermedades propias de los huesos." +
                "<br><b>&#8226; Agentes externos: </b>Son provocados por trauma, fuerza desproporcionada, movimiento desmedido que ocasionan esguinces, fracturas y luxaciones.\n" +
                "<br><b>&#8226; Agentes Internos</b>: Enfermedades que afectan el sistema óseo; ejemplo: Osteoporosis, leucemia y cáncer de huesos" +
                "<br><br><b>Signos y Síntomas de Fracturas:</b><br>" +
                "&#8226; Deformidad.<br> " +
                "&#8226; Inflamación.<br> " +
                "&#8226; Incapacidad de movimiento.<br> " +
                "&#8226; Aumento o acortamiento del miembro.<br>" +
                "&#8226; Área lesionada  entumecida y fría.<br> " +
                "&#8226; La piel tiene un color Azul." +
                "<br><br><b>Primeros auxilios para fracturas</b>"+
                "<br><br>Los huesos y articulaciones fracturadas o lesionadas deben ser inmovilizados  para que de esta forma puedan prevenir mayores lesiones y disminuir  el dolor." +
                "<br><br><b>En la atención de estas lesiones se utilizan:</b> férulas, vendas de rollo y vendas triangulares.";

        String contenidoFractura2="<br><br><b><h2></h2></b>"
                +"<br>Un entablillado puede ser preparado comercialmente o improvisado. También  es posible utilizar una parte del cuerpo que no se encuentre lesionada, por  ejemplo: La otra pierna o el costado del cuerpo." +
                "<br><br><b>¿Qué hacer?</b>" +
                "<br>&#8226; No haga nada que le cause más dolor a la persona.<br>" +
                "&#8226; Inmovilice el área lesionada en posición de mayor comodidad.<br>" +
                "&#8226; Examine la circulación distal antes y después de la inmovilización.<br>" +
                "&#8226; Tranquilizar a la persona afectada.<br>" +
                "&#8226; Visualizar la fractura y estabilizar manualmente.<br>" +
                "&#8226; Seleccionar el material de inmovilización adecuado.<br>";

        ArrayList<Respuestas>  respuestaHeridas = new ArrayList<Respuestas>();
        respuestaHeridas.add(new Respuestas("Perdida de visión", false));
        respuestaHeridas.add(new Respuestas("Dolor intenso en el área afectada", true));
        respuestaHeridas.add(new Respuestas("Pérdida de audición", false));


        Preguntas preguntaHerida = new Preguntas("Síntomas de una fractura", respuestaHeridas);

        ArrayList<AtencionesEmergencias>  fracHeridaHemo = new ArrayList<AtencionesEmergencias>();
        fracHeridaHemo.add(new AtencionesEmergencias(R.drawable.heridas1info,herida1, "Heridas", preguntaHerida));
        fracHeridaHemo.add(new AtencionesEmergencias(R.drawable.heridas2info,hemorragea1, "Hemorragia", preguntaHerida));
        fracHeridaHemo.add(new AtencionesEmergencias(R.drawable.heridas2info,contenidoFractura1, "Fracturas", preguntaHerida));
        fracHeridaHemo.add(new AtencionesEmergencias(R.drawable.heridas2info,contenidoFractura2, "Inmovilización", preguntaHerida));





        //---------------------------------------Transporte y camillaje----------------------------------------------------------



        String contenidoTransporte1="<br><br><b>Objetivos generales</b>" +
                "<br><br>&#8226; El objetivo es evitar que las lesiones existentes empeoren o que con su accionar se originen otras nuevas." +
                "<br>&#8226; Para lograr este objetivo, es necesario garantizar un adecuado transporte desde el área de impacto a un lugar seguro para su evaluación y estabilización; utilizar diferentes elementos como gasa, pañuelos, telas, sillas, camillas, tablas, etc. los que permiten vendar e inmovilizar las distintas lesiones encontradas." +
                "<br><br><b>Considera estos tres aspectos.</b>" +
                "<br>&#8226; Vendajes." +
                "<br>&#8226; Inmovilización." +
                "<br>&#8226; Traslado de Pacientes.";

        String contenidoTransporte2="<br><br>&#8226; Los vendajes son procedimientos que tienen como objetivo cubrir con una venda, una zona lesionada" +
                "<br>&#8226; Venda: Es una porción de gasa, tela o cualquier otro material que pueda utilizarse para los fines antes mencionados; por lo general, las vendas son de dos tipos : Las triangulares y enrolladas." +
                "<br><br><b>Tipos de Vendajes</b>" +
                "<br><b>Vendaje en espiral: </b>Se emplea una venda elástica o semielástica porque se puede adaptar a la zona que se va a vendar, se utiliza para sujetar gasas, apósitos o férulas en brazos, mano, muslo y piernas." +
                "<br><b>Método: </b>Seleccione el tamaño adecuado, inicie el vendaje desde la parte más distal en dirección a la circulación  venosa, las vueltas de la venda ascienden en espiral, de tal manera, que cada vuelta cubra dos tercios de la vuelta anterior, luego fije la punta con un nudo, esparadrapo o un gancho." +
                "<br><br><b>Vendaje en ocho: </b>Esta técnica se aplica en las articulaciones (tobillos, rodilla, codo, etc.). Útil para sujetar apósitos ( utilizados para control de hemorragias)  e inmovilizar." +
                "<br><b>Método: </b>Dé una vuelta circular al inicio, seguida de un cruce de la venda en forma de ocho, puede terminar con otra vuelta" +
                "<br><br><b>Vendaje de la mano: </b>Puede realizarse en forma oblicua desde la palma de la mano hacia la muñeca y luego terminar cubriendo los dedos o dejándolos libres e incluyendo el pulgar." +
                "<br><br><b>Vendaje de los dedos: </b>Cuando se quiere vendar un dedo es conveniente dejar libre su extremidad para poder vigilar la circulación. Se comenzará en la muñeca, haciendo 3 ó 4 vueltas alrededor del dedo vendado" +
                "<br><br><b>Vendaje de cabestrillo: </b>Con una venda, se mide el largo adecuado, se amarra en sus puntas y se coloca pasando por debajo del antebrazo para sostenerlo e inmovilizarlo en el movimiento de abajo y arriba, el otro extremo se fija sobre la nuca (el brazo debe estar de forma tal que la mano esté " +
                "un poco más alta que el codo) tiene como inconveniente que no inmoviliza completamente el miembro superior, aunque podemos limitar más el movimiento si pasamos otra venda o pañuelo en forma trasversal sobre la parte media del tórax." +
                "<br><br><b>Vendaje de la cabeza: </b>Para ello lo más utilizado es el vendaje de capelina, primero se hacen dos circulares " +
                "alrededor de la cabeza, al llegar a la región occipital, se hace un inverso en ángulo recto que llevará la venda a la frente donde se hace otro inverso, esta maniobra se " +
                "repite hasta cubrir totalmente la cabeza, luego se repite el vendaje circular para fijar los extremos de las vueltas del frente a la parte posterior.";



            String contenidoTransporte3="<br><br>&#8226; Uno de los elementos más importantes en el manejo de las lesiones óseas (fracturas, luxaciones), de partes blandas (heridas, contusiones) y de las articulaciones (esguince) es la inmovilización firme e ininterrumpida de las áreas correspondientes." +
                    "<br>&#8226; Ya, al explicar las técnicas para vendajes, se incorporaron algunos conceptos y modos de inmovilizar, lo cual se perfecciona si utilizamos métodos manuales o con aditamentos." +
                    "<br><br><b>¿Qué se logra al inmovilizar una lesión?</b>" +
                    "<br>&#8226; Alivio del dolor, ello también previene el shock." +
                    "<br>&#8226; Se evita incrementar el daño a los tejidos cercanos a ella, al reducir el movimiento de los extremos de los huesos que ahora tienen una superficie irregular." +
                    "<br>&#8226; Disminuir el sangramiento (se forma un coágulo en el sitio de la lesión)." +
                    "<br><br><b>Principios básicos de las inmovilizaciones.</b>" +
                    "<br>&#8226; Mantener las líneas y ejes del cuerpo." +
                    "<br>&#8226; Mantener las articulaciones en posición funcional." +
                    "<br>&#8226; Acolchar o almohadillar en los sitios donde las eminencias óseas se ponen en contacto con   la férula." +
                    "<br>&#8226; No tratar de reducir fracturas en el sitio del accidente." +
                    "<br>&#8226; En fracturas de huesos por su parte central, inmovilice al menos una articulación por encima y una por debajo." +
                    "<br>&#8226; Inmovilice el hueso que está por encima y por debajo de la lesión, si hay fracturas en articulaciones." +
                    "<br>&#8226; La venda no debe estar ni muy apretada ni muy floja." +
                    "<br>&#8226; Si existe una herida, cúbrala con un apósito estéril antes de colocar la férula y no anude sobre ella." +
                    "<br><br><b>Principios para el manejo de un traumatismo de columna:</b>" +
                    "<br>&#8226; Efectúe inmovilización manual alineada." +
                    "<br>&#8226; Evalúe y resuelva el ABCD de la resucitación." +
                    "<br>&#8226; Concluya la revisión sistemática total y valore la respuesta al movimiento, trastornos de la sensibilidad o la circulación en las extremidades." +
                    "<br>&#8226; Inmovilice el tronco." +
                    "<br>&#8226; Coloque almohadillamiento debajo de la cabeza (y del tronco en el niño)." +
                    "<br>&#8226; Inmovilice la cabeza." +
                    "<br>&#8226; Inmovilice las piernas y los brazos." +
                    "<br>&#8226; Reevalúe el ABC y traslade.(Abrir vías aéreas, Busque respiración, Controle circulación)." +
                    "<br><br><b>Inmovilización manual de la columna cervical.</b>" +
                    "<br>&#8226; Para inmovilizar la columna cervical existen varias técnicas, en dependencia de la posición y estado del lesionado." +
                    "<br>&#8226; <b>Está contraindicado llevar la cabeza a la posición neutral alineada si:</b>" +
                    "<br>&#8226; Existe contractura o dolor de los músculos del cuello." +
                    "<br>&#8226; La maniobra compromete la vía aérea o la ventilación." +
                    "<br>&#8226; Desencadena o empeora trastornos neurológicos (hormigueo, calambres, parálisis o dolor)." +
                    "<br><br><b>Inmovilización para retirar un casco: </b>" +
                    "<br>&#8226; La mayoría de las complicaciones cervicales en pacientes motociclistas se debe al retiro del casco de una forma no correcta." +
                    "<br>&#8226; Debe hacerse entré dos personas, el primero se arrodilla detrás de la cabeza de la víctima, con sus palmas de las manos contra los lados del casco y los dedos flexionados sobre su margen inferior, tratando de llevar la cabeza a la posición neutral alineada." +
                    "<br>&#8226; El segundo rescatador también arrodillado, abre y quita la careta, evalúa la vía aérea y desabrocha las correas del mentón." +
                    "<br>&#8226; Luego coloca una mano en la parte posterior y la otra en la mandíbula para realizar una inmovilización manual de frente." +
                    "<br>&#8226; El primer socorrista, ahora retira cuidadosamente el casco pudiendo ser necesario un cambio de manos en el momento en que el casco levanta la parte posterior de la cabeza. Para terminar, se produce un nuevo cambio de manos en el cual el primer rescatador queda realizando la inmovilización manual desde la posición de atrás.";

        String contenidoTransporte4="<br><br><b><h2>Inmovilización  de la columna vertebral.</h2></b>" +
                "<br>&#8226; Inmovilización de la columna cervical con collarín son dispositivos que aunque no inmovilizan  completamente la columna cervical, limitan los movimientos de la cabeza en un 50-75 %." +
                "<br>&#8226; Para que sea efectivo, debe seleccionarse el tamaño adecuado y colocarlo con un movimiento mínimo sobre la cintura escapular y debajo de la mandíbula." +
                "<br>&#8226; Reglas para su uso: No debe estar ni flojo ni apretado (comprime las venas del cuello), debe permitir la apertura de la boca (útil si hay vómitos), no debe dificultar la respiración y debe aplicarse luego que la cabeza haya sido colocada en posición neutral alineada. " +
                "<br>&#8226; Un collarín cervical puede improvisarse con un pañuelo Triangular, bolsas de suero, o el uso de cuatro gorras." +
                "<br><br>Inmovilización de la columna con tabla espinal larga, es una forma de inmovilización muy efectiva, que permite un traslado " +
                "seguro y con un mínimo de personas . Para colocar la tabla, las correas (tórax, abdomen al nivel de las crestas ilíacas, muslos, " +
                "tobillos, cabeza y mentón) deben estar sueltas y listas. Coloque al paciente boca arriba, alineado, los brazos al lado del cuerpo, con la palma de las manos hacia adentro";


        String contenidoTransporte5="<br><b><h2>Inmovilización de los brazos y piernas.</h2></b>" +
                "<br>Por seguridad, los brazos deben ser sujetados a la tabla antes de mover al paciente, las palmas de las manos hacia adentro (pegadas al cuerpo), sujetados con una correa sobre los antebrazos." +
                "<br><b><h2>Traslado de pacientes.</h2></b>" +
                "<br>&#8226; No siempre es posible brindar asistencia médica en el sitio donde se produce una emergencia; por ello, es necesario el traslado a otro sitio (fuera del escenario o a centros de salud) donde las condiciones sean más adecuadas o donde no exista peligro para el rescatista  o la víctima." +
                "<br>&#8226; El traslado de enfermos debe realizarse con todas las condiciones que garanticen la estabilidad y se deben utilizar los vehículos y medios adecuados. Mueva a la persona sólo cuando sea absolutamente necesario, pues ello puede empeorar lesiones existentes." +
                "<br>&#8226; Para el traslado de pacientes, debemos tener en cuenta dos situaciones: El transporte desde el sitio del evento hasta un lugar seguro para su evaluación y manejo y su evacuación hacia los centros de salud, incluidos los hospitales." +
                "<br><br><b>Técnicas Empleadas: </b>" +
                "<br>&#8226; Traslado sin medios." +
                "<br>&#8226; Arrastre." +
                "<br>&#8226; Soporte o “muleta humana”." +
                "<br>&#8226; Cargue en brazos." +
                "<br>&#8226; Cargue de bombero." +
                "<br>&#8226; Silla de dos y de cuatro manos." +
                "<br>&#8226; Técnica de tres o cuatro socorristas." +
                "<br>&#8226; Extracción desde un auto por un socorrista." +
                "<br><br><b>Traslado entre tres o cuatro Rescatistas.</b>" +
                "<br>Para movilizar un herido hacia la camilla (esta debe ir hacia él y no al revés), el lesionado debe sostenerse por, al menos seis puntos de apoyo: " +
                "<br>&#8226; Un punto bajo el conjunto cabeza y nuca." +
                "<br>&#8226; De 3 a 5 puntos bajo el tronco." +
                "<br>&#8226; Dos puntos debajo de los miembros inferiores.";

        String contenidoTraslado6="<br><br><b><h2>Extracción desde un auto por un Rescatista.</h2></b>" +
                "<br>&#8226; En esta variante, el Rescatista  abre la puerta y trata de rotar al lesionado de forma tal que se pueda ubicar detrás, su brazo" +
                "derecho lo corre por debajo de la axila del mismo lado del paciente para, con la mano, sostenerlo por la mandíbula y hacer " +
                "férula con el antebrazo de forma tal que se mantenga alineada la columna cervical y torácica." +
                "<br>&#8226; Su otro brazo lo desplaza por debajo de la otra axila y sostiene el brazo derecho del paciente a nivel de la parte media del antebrazo." +
                "<br>&#8226; Una vez sostenido el paciente, se arrastra hacia atrás de forma tal que se traslade a un lugar seguro para realizar su evaluación." +
                "<br><br><b>Camilla de Costales.</b>" +
                "<br>Esta se elabora con dos costales del mismo tamaño y dos palos (varas) que sobrepasen el tamaño del paciente, " +
                "se hacen dos agujeros al fondo del costal por donde se pasa los palos, convirtiendo en una camilla, para el " +
                "traslado de la victima se puede usas una manta." +
                "<br><br><b><h2>Espera para el traslado</h2></b>" +
                "<br>Una vez concluida la evaluación del ABC y realizada las curas e inmovilización de lesiones, puede ser necesaria la espera para el traslado hacia los centros de salud, lo más adecuado es tener un empaquetamiento sobre una tabla espinal larga, pero ello en ocasiones no es posible dado lo escaso de recursos, fundamentalmente frente a lesionados múltiples, una variante es colocarlo en posición de rescate o envolverlo con una manta o sábana.";
        String contenidoTraslado7="<br>&#8226; Coloque a la víctima boca arriba, en posición neutral alineada, Tome el brazo más cercano a usted y elévelo formando ángulo recto en el codo, con el antebrazo en paralelo con el cuerpo y la palma de la mano hacia arriba." +
                "<br>&#8226; Traiga el otro brazo sobre el tórax de forma tal que la parte posterior de la mano quede en contacto con la mejilla más cercana a usted y sosténgala con una mano con su otra mano, eleve la pierna más alejada sosteniéndola al nivel de la rodilla, luego con un movimiento hacia sí, rote en bloque a la víctima, de esta forma, una mano queda debajo de la boca, lo que eleva la cabeza del suelo permitiendo una mejor respiración y evitando que de producirse un vómito, este sea ,por otro lado al quedar una pierna hacia delante y con la rodilla en ángulo recto, evita el movimiento en esta dirección." +
                "";

        String contenidoTraslado8="";






        ArrayList<Respuestas>  respuestasTransporte = new ArrayList<Respuestas>();
        respuestasTransporte.add(new Respuestas("Perdida de visión", false));
        respuestasTransporte.add(new Respuestas("Dolor intenso en el área afectada", true));
        respuestasTransporte.add(new Respuestas("Pérdida de audición", false));


        Preguntas preguntaTransporte = new Preguntas("Síntomas de una fractura", respuestaHeridas);

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
        String contenidoRescateAcuatico1="<br><br><<b><h2>Objetivos generales.</h2></b>" +
                "&#8226; Actuar en condiciones de posible emergencia, transmitiendo con serenidad, celeridad las señales de alarma y aplicando los medios de seguridad establecidos." +
                "<br>&#8226; Resolver las contingencias que se presenten en relación a las personas, las instalaciones y los equipos o materiales, informando de inmediato a los servicios de emergencia 911 cuando las repercusiones o la problemática superen su ámbito de actuación." +
                "<br>&#8226; Administración de primeros auxilios en caso de accidente o enfermedad." +
                "<br>&#8226; Enseñar las técnicas propias de la actividad utilizando los equipos de salvamento y/o socorrismo, demostrando los movimientos y corrigiendo los errores de ejecución de los participantes." +
                "<br>&#8226; Mantenerse informado sobre las últimas aportaciones técnicas o científicas relacionadas con el salvamento y los primeros auxilios que pueden ser beneficiosos en su trabajo, con el fin de incorporar las nuevas técnicas y tendencias, estando actualizando en todo momento y puesto al día en cuanto a nuevos equipos, materiales y técnicas que  se conozcan." +
                "<br>&#8226; Utilizar y buscar fuentes de información y formación relacionadas con el ejercicio de la profesión que posibiliten el conocimiento y la inserción en el sector de las actividades físicas y/o deportivas,  la evolución y adaptación de las capacidades profesionales propias a los cambios tecnológicos y organizativos que se producirán a lo largo de toda la vida activa." +
                "<br><b><h2>Objetivos específicos.</h2></b>" +
                "Al termino de este módulo, el alumno deberá haber adquirido las siguientes capacidades:" +
                "<br>&#8226; Identificar los primeros auxilios que se deben prestar para cada tipo de lesión o enfermedad." +
                "<br>&#8226; Aplicar las técnicas de los primeros auxilios en función del tipo de accidente o lesión según los protocolos establecidos." +
                "<br>&#8226; Analizar las posibilidades de peligros en las instalaciones o zonas acuáticas naturales y los procedimientos a seguir para realizar el rescate acuático." +
                "<br>&#8226; Realizar con seguridad y eficacia las maniobras de salvamento acuático." +
                "<br><b><h2>Requerimientos.</h2></b>" +
                "&#8226; Seguir rigurosamente los puntos de prevención y aviso para optimizar la seguridad (zonas mas peligrosas)." +
                "<br>&#8226; Reconocer en las personas signos de tener problemas para nadar y/o mantenerse a flote." +
                "<br>&#8226; Decidir con rapidez, tras analizar la situación globalmente, y teniendo en cuenta el estado de la persona en peligro de ahogamiento y los recursos disponibles, la manera de prestarle auxilio (lanzamiento de cuerda, boya, flotador, etc, tipo de rescate, rescate a nado, con ayuda de medios auxiliares, entre varios socorristas, etc, selección de entrada al agua, según condición, profundidad, rápidas,  posibles corrientes, lentas  o turbulentas)." +
                "<br>&#8226; Aproximación a la persona que hay que rescatar o socorrer nadando a cualquier estilo, pero sin perderla de vista y accediendo al mismo por la espalda." +
                "<br>&#8226; Extraer del agua a la persona auxiliada, utilizando las técnicas pertinentes y apropiadas en función de sus características y del medio acuático donde se realice (recuerde el agua en el estomago no esta matando el paciente, es el agua en sus pulmones )." +
                "<br>&#8226; Valorar el estado de gravedad de los enfermos o accidentados, estableciendo la prioridad de atención y/o evacuación." +
                "<br>&#8226; Aplicar los cuidados de urgencia siguiendo los protocolos y puntos de actuación establecidos (RCP/ RA según sea el caso)." +
                "<br>&#8226; Establecer comunicación con los servicios de emergencia 911, si la situación lo exigiera." +
                "<br>&#8226; Realizar en caso de necesidad urgente la evacuación y/o traslado del enfermo o accidentado en condiciones de seguridad y utilizando el sistema más adecuado a la lesión y nivel de gravedad.";

        String contenidoRescateAcuatico2="<br><br><b><h2>Zonas con Diferente Prioridad de Observación e Intervención:</h2></b>" +
                "&#8226; <b>Primaria: </b>Constituye la superficie  de agua de la instalación y deben ser siempre vigiladas sin interrupción. Su observación es prioritaria, ya que es donde se producen los accidentes más graves y donde, por definición legal, trabaja el socorrista acuático." +
                "<br>&#8226; <b>Secundaria: </b>Constituye la playa circundante a la superficie de agua, no precisa vigilancia constante, pero debe ser regularmente observada." +
                "<br>&#8226; <b>Terciaria: </b>son otras áreas o dependencias de la instalación.  No es necesario vigilarlas pero se deben inspeccionar diariamente para detectar y eliminar posibles fuentes de accidente ( tanques de almacenamientos de agua, diques de desagüe etc)." +
                "<br><br><b>Formas de entrada al agua y acercamiento al accidentado: </b>" +
                "<br>&#8226; Técnica de agarre y zafa." +
                "<br>&#8226; Salvamento en profundidad" +
                "<br>&#8226; El síndrome de inmersión." +
                "<br>&#8226; Sistemas de remolque." +
                "<br>&#8226; Formas de sacar al accidentado. En piscina. En medio natural acuático." +
                "<br>&#8226; Material de seguridad y salvamento: Procedimientos y técnicas con material de auxilio." +
                "<br>&#8226; Salvamento en instalaciones acuáticas y en zonas acuáticas naturales." +
                "<br>&#8226; Técnicas especificas de nado en el medio acuático." +
                "<br>&#8226; Desplazamiento en el medio acuático con niveles de resistencia y velocidad adecuados." +
                "<br><br><b>Técnicas de natación para rescate acuático:</b>" +
                "<br>&#8226; Tener presente el HALEM (H:hablar, A:acercar, L:lanzar línea, E:extraer, N:nadar)." +
                "<br>&#8226; Maniobras de entrada, aproximación, control y remolque en diferentes situaciones." +
                "<br>&#8226; Posición del cuerpo." +
                "<br>&#8226; Ubicación con relación a la dirección de la corriente." +
                "<br>&#8226; Acción de brazos y piernas." +
                "<br>&#8226; Respiración." +
                "<br>&#8226; Coordinación." +
                "<br>&#8226; Natación con aletas.";

        String contenidoRescateAcuatico3="<br><br><b><h2>Técnicas de natación para rescate acuático.</h2></b>" +
                "&#8226; Natación con equipo auxiliar de salvamento acuático: chalecos, cascos, cinturones, flotadores, arneses, boyas, silbato y flotadores de otro tipo." +
                "<br>&#8226; Apoyo con lanchas y/o botes." +
                "<br>&#8226; Maniobra de extracción del medio de un posible accidentado con seguridad y eficacia." +
                "<br>&#8226; Señales universales de rescate acuático." +
                "<br><br><b><h2>Principios generales del rescate acuático</h2></b>" +
                "<br><b>1. Prevención: </b>" +
                "<br>Conjunto de preparativos que se disponen con anticipación para advertir, evitar e impedir un suceso o accidente mediante la educación, divulgación y servicio." +
                "<br><br><b>2. Vigilancia: </b>" +
                "<br>Es la labor continuada de observación, cuidado y atención del espacio en que se desarrolla la actividad, (piscina, instalación acuática, río, embalse, playa. etc.), por medio de la cual el Rescatista informa a los usuarios, previene los problemas, percibe los accidentes, e inicia las acciones para resolver adecuadamente cualquier incidencia o accidente que pueda producirse." +
                "<br><b>Elementos psicológicos de la vigilancia. </b>" +
                "<br>&#8226; Percepción: por parte del Rescatista de lo que sucede (Visión directa y Audición)." +
                "<br>&#8226; Atención: situación de alerta durante todo el tiempo que dure su labor." +
                "<br>&#8226; Concentración: vigilar la zona de modo selectivo y excluyente." +
                "<br>&#8226; Motivación: sentirse respetado y valorado supone  un refuerzo adicional para realizar su labor." +
                "<br>&#8226; Intereses y valores: la observación a corto plazo se realiza en función de experiencias y formación pero a largo plazo son los intereses (base solidaria y altruista) del Socorrista." +
                "<br><br><b>3. Control: </b>" +
                "<br>El Rescatista debe dominar la situación en todo momento, no confiar en la improvisación. Conservar la serenidad y sangre fría, pero con rapidez y eficacia. No se deben correr riesgos innecesarios." +
                "<br><b>Estrategias de control visual sobre la zona de baño: </b>" +
                "<br>- Vigilancia global: todos los Rescatistas vigilan la totalidad de la zona." +
                "<br>- Vigilancia por sectores: cada Rescatista  una zona (zonas contiguas superpuestas)." +
                "<br>- Vigilancia mixta" +
                "<br><br><b>Estrategias de observación: </b>" +
                "<br>Grupo de riesgo, Niveles de nado y por edades." +
                "<br><br><b></b>Sistema 10:20" +
                "<br>Observar todo en 10 segundos y llegar a cualquier zona en 20." +
                "<br><br><b>4.  Presteza: </b>" +
                "<br>Se define como la necesidad de reducir el tiempo de rescate. <br>No pensando en precipitación, nerviosismo o realizando las cosas sin pensar sino a la prontitud y brevedad en nuestras acciones, ejecutándolas siempre correcta y eficazmente, con habilidad y sin el menor riesgo para aquellas personas a las que se rescata." +
                "<br><br>5. Diagnóstico y Actuación</b>" +
                "<br>&#8226; Diagnóstico: Valorar la situación correctamente y tomar la decisión. En el caso de una atención primaria, valorar el estado de la víctima y establecer el diagnóstico descubriendo la causa del accidente." +
                "<br>&#8226; Actuación: Efectuar las técnicas de remolque y extracción del accidentado decididas. En su caso realizar las técnicas de primeros auxilios necesarias.";

            String contenidoRescateAcuatico4="<br><br><b><h2></h2>Principios básicos de cobertura</b>" +
                    "<br>&#8226; Delimitar el periodo de cobertura: Durante este periodo se asegura la vigilancia; este debe ser conocido y expuesto públicamente, informando que fuera de el no existe responsabilidad y que el usuario utiliza la instalación bajo su propia responsabilidad, asumiendo el riesgo de no ser vigilado." +
                    "<br>&#8226; Delimitar los limites de la zona: Adecuándola a la capacidad de la vigilancia y teniendo en cuenta el tamaño total de la instalación, el numero de usuarios y la actividades que en ella se realizan." +
                    "<br><br><b>Recomendaciones Generales </b>" +
                    "<br>&#8226; Conocer la zona de baño." +
                    "<br>&#8226; No bañarse solo." +
                    "<br>&#8226; Mójate antes de entrar en el agua." +
                    "<br>&#8226; Respeta las horas de digestión." +
                    "<br>&#8226; Vigila de cerca de niños y ancianos." +
                    "<br>&#8226; Si ves a alguien en peligro pide ayuda." +
                    "<br>&#8226; Si estas en peligro, conserva la calma." +
                    "<br><br><b>Recomendaciones para los rescatistas.</b>" +
                    "<br>&#8226; Los niveles altos de concentración  se pueden mantener 30-40 minutos." +
                    "<br>&#8226; Ninguna zona debe quedar desprotegida en ningún momento." +
                    "<br>&#8226; El Rescatista que vuelva de descansar  debe acudir al puesto de mayor saturación de gente o tiempo de vigilancia.";



        ArrayList<Respuestas>  respuestasRescateAcuatico = new ArrayList<Respuestas>();
        respuestasRescateAcuatico.add(new Respuestas("Perdida de visión", false));
        respuestasRescateAcuatico.add(new Respuestas("Dolor intenso en el área afectada", true));
        respuestasRescateAcuatico.add(new Respuestas("Pérdida de audición", false));


        Preguntas preguntaRescateAcuatico = new Preguntas("Síntomas de una fractura", respuestaHeridas);

        ArrayList<AtencionesEmergencias>  rescateAcuatico = new ArrayList<AtencionesEmergencias>();
        rescateAcuatico.add(new AtencionesEmergencias(R.drawable.imgrescateacuatico1,contenidoRescateAcuatico1, "Rescate Acuático", preguntaRescateAcuatico));
        rescateAcuatico.add(new AtencionesEmergencias(R.drawable.imgacuatico2,contenidoRescateAcuatico2, "Rescate Acuático", preguntaRescateAcuatico));
        rescateAcuatico.add(new AtencionesEmergencias(R.drawable.imgacuatico3,contenidoRescateAcuatico3, "Rescate Acuático", preguntaRescateAcuatico));
        rescateAcuatico.add(new AtencionesEmergencias(R.drawable.imgacuatico4,contenidoRescateAcuatico3, "Rescate Acuático", preguntaRescateAcuatico));


        //---------------------------------------------------------------------------------------------------------------------

        primerosAuxilios.add(new PrimerosAuxilios("Buscando que las comunidades sean más resilientes a los choques, factores de estrés y desastres.","Resiliencia Comunitaria", R.drawable.resilecinaicon, resiliencia));
        primerosAuxilios.add(new PrimerosAuxilios("¿Cómo debes actuar durante una emergencia?", "Primeros Auxilios Psicológicos ", R.drawable.inmo_icon, ayudaPsicologica));
        primerosAuxilios.add(new PrimerosAuxilios("Sistema de clasificación de víctimas.","Triajes", R.drawable.triageicon, triages));
        primerosAuxilios.add(new PrimerosAuxilios("Primeros auxilios básicos","Atención de Heridas, Hemorragias y fracturas.", R.drawable.fracturalist, fracHeridaHemo));
        primerosAuxilios.add(new PrimerosAuxilios("¿Cómo transportar personas lesionadas?","Transporte y camillaje.", R.drawable.fracturalist, transporte));
        primerosAuxilios.add(new PrimerosAuxilios("¿Cómo transportar personas lesionadas?","Rescate acuático.", R.drawable.fracturalist, rescateAcuatico));
        primerosAuxilios.add(new PrimerosAuxilios("¿Cómo debes actuar durante una emergencia?", "Sistema de Manejo de Emergencias", R.drawable.manejo, comandosEmergencias));
    }


}
