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

        String contenidoFractura1="<br><br>\nEs la ruptura parcial o total de un hueso, causadas por factores externos o internos como enfermedades propias de los huesos." +
                "\n" +
                "\n<br><b>&#8226; Agentes externos: </b>Son provocados por trauma, fuerza desproporcionada, movimiento desmedido que ocasionan esguinces, fracturas y luxaciones.\n" +
                "\n" +
                "\n<br><b>&#8226; Agentes Internos</b>: Enfermedades que afectan el sistema óseo; ejemplo: Osteoporosis, leucemia y cáncer de huesos" +
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

        String contenidoFractura4="<br><br>Un entablillado puede ser preparado comercialmente o improvisado. También  es posible utilizar una parte del cuerpo que no se encuentre lesionada, por  ejemplo: La otra pierna o el costado del cuerpo.";

        String contenidoFractura5="" +
                "<br><br>&#8226; No haga nada que le cause más dolor a la persona.<br>" +
                "&#8226; Inmovilice el área lesionada en posición de mayor comodidad.<br>" +
                "&#8226; Examine la circulación distal antes y después de la inmovilización.<br>" +
                "&#8226; Tranquilizar a la persona afectada.<br>" +
                "&#8226; Visualizar la fractura y estabilizar manualmente.<br>" +
                "&#8226; Seleccionar el material de inmovilización adecuado.<br>";

        ArrayList<Respuestas>  respuestaFractura = new ArrayList<Respuestas>();
        respuestaFractura.add(new Respuestas("Perdida de visión", false));
        respuestaFractura.add(new Respuestas("Dolor intenso en el área afectada", true));
        respuestaFractura.add(new Respuestas("Pérdida de audición", false));


        Preguntas preguntaFractura = new Preguntas("Síntomas de una fractura", respuestaFractura);

        ArrayList<AtencionesEmergencias>  fractura = new ArrayList<AtencionesEmergencias>();
        fractura.add(new AtencionesEmergencias(R.drawable.fractura1, contenidoFractura1, "Fracturas", preguntaFractura));
        fractura.add(new AtencionesEmergencias(R.drawable.inmobilizacioninfo1, contenidoFractura4, "Inmobilización", preguntaFractura));
        fractura.add(new AtencionesEmergencias(R.drawable.inmobilizacioninfo2, contenidoFractura5, "¿Qué hacer?", preguntaFractura));
//------------------------------------------HEmorragia-------------------------------------------------------------------------
        String hemorragea1="<br><br>Es la pérdida abundante de sangre al romperse un vaso sanguíneo" +
                "<br><br><b>Tipos de hemorragias: </b><br>" +
                "&#8226; Hemorragia Arterial: Sangre de color rojo que sale de forma intermitente coincidiendo con los latidos del corazón.<br>" +
                "&#8226; Hemorragias Venosas: Sangre de color oscuro y que sale de forma continua.<br>" +
                "&#8226; Hemorragia Capilar: Sangrado de color  rojo que sale de forma lenta.<br>" +

                "<br><br><b>Clasificación  de las Hemorragias: </b><br>" +
                "&#8226; Hemorragia Externa: Se acompaña de una herida en la piel y se observa salida de sangre hacia afuera.<br>" +
                "&#8226; Hemorragia Interna: El sangrado es interno. Este sangrado puede salir por los orificios naturales del cuerpo, convirtiéndose  en hemorragia  exteriorizada.<br>";

        String hemorragia2="<br><br>&#8226; <b>Haga  presión directa:</b> Use guantes y ejerza presión sobre la herida.<br>" +
                "&#8226; <b>Elevación:</b> Elevar las extremidades afectadas (piernas o brazos), para aminorar la salida de sangre al sitio de la herida. Si no existen fracturas u objetos ensartados  se elevan las extremidades afectadas a un nivel más alto que el del corazón.<br>" +
                "&#8226; <b>Presión Indirecta:</b> Usando la yema de los dedos, la palma de la mano, se apretará en el sitio afectado donde podamos prensar la arteria por donde sale la sangre contra el hueso, a fin de evitar el paso de la sangre.<br>";


        ArrayList<Respuestas>  respuestaHemorragia = new ArrayList<Respuestas>();
        respuestaFractura.add(new Respuestas("Perdida de visión", false));
        respuestaFractura.add(new Respuestas("Dolor intenso en el área afectada", true));
        respuestaFractura.add(new Respuestas("Pérdida de audición", false));


        Preguntas preguntaHemorragia = new Preguntas("Síntomas de una fractura", respuestaFractura);

        ArrayList<AtencionesEmergencias>  hemorrageas = new ArrayList<AtencionesEmergencias>();
        hemorrageas.add(new AtencionesEmergencias(R.drawable.heridas1info, hemorragea1, "Hemorragias", preguntaHemorragia));
        hemorrageas.add(new AtencionesEmergencias(R.drawable.heridas2info, hemorragia2, "Primeros Auxilios para hemorragias", preguntaHemorragia));

//---------------------------------HEridas------------------------------------------------------------------------


        String herida1="<br><br>Es la separación de los tejidos de la piel, que puede dejar al descubierto otras partes del cuerpo como los huesos y otros órganos del ser humano que se encuentran internamente.";
        String herida2="<br><br>" +
                "&#8226; <b>Cortantes :</b> Bordes rectilíneos (cuchillo, gillette, navaja).<br>" +
                "&#8226; <b>Lacerantes :</b> Bordes irregulares (latón, sierra, vidrio).<br>" +
                "&#8226; <b>Punzantes:</b> Orificio a veces con salida (punzón, clavos, agujas).<br>" +
                "&#8226; <b>Contusas:</b> Golpes fuertes (pedradas, martillazos).<br>" +
                "&#8226; <b>Corto Punzante:</b> Bordes rectilíneos  y orificio (verruguilla, navaja).<br>" +
                "&#8226; <b>Avulsiva:</b> Desgarre o pérdida de un miembro o parte del cuerpo.<br><br>";


        ArrayList<Respuestas>  respuestaHeridas = new ArrayList<Respuestas>();
        respuestaFractura.add(new Respuestas("Perdida de visión", false));
        respuestaFractura.add(new Respuestas("Dolor intenso en el área afectada", true));
        respuestaFractura.add(new Respuestas("Pérdida de audición", false));


        Preguntas preguntaHerida = new Preguntas("Síntomas de una fractura", respuestaFractura);

        ArrayList<AtencionesEmergencias>  heridas = new ArrayList<AtencionesEmergencias>();
        heridas.add(new AtencionesEmergencias(R.drawable.heridas1info,herida1, "¿Qué es una Herida?", preguntaHerida));
        heridas.add(new AtencionesEmergencias(R.drawable.heridas2info, herida2, "Los elementos que pueden producir heridas son: ", preguntaHerida));


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

                "<br><br><b>Siempre que sea posible en respuesta a una situación de crisis</b><br>" +
                "&#8226; Siga las indicaciones de las autoridades competentes a cargo de la gestión de la crisis.<br>" +
                "&#8226; Infórmese de las respuestas de emergencia  que están organizando, y de los recursos disponibles" +
                "si existieran para ayudar a las personas.<br>" +
                "&#8226; No estorbe al personal de búsqueda y rescate o al personal médico de emergencia.<br>" +
                "&#8226; Sea consciente  de su rol, y de los límites de su rol.<br><br>";

        String psicologico4="<br>" +
                "<br><b>Lo que debemos hacer y decir: </b><br>" +
                "&#8226; Dé la información de un modo en que la persona la pueda atender, es decir de formas simples.<br>" +
                "&#8226; Hágale saber que comprende, cómo se sienten y que lamenta sus pérdidas y lo que les ha pasado, como haberse quedad sin hogar " +
                "o haber perdido un ser querido.<br>" +
                "&#8226; Hágale saber que reconoce sus fortalezas y la manera en que están ayudando a sí mismos.<br>" +
                "&#8226; Deje espacios para el silencio.<br>" +

                "<br><br><b>Brinde información</b><br>" +
                "<br><b>Las personas afectadas por una situación de crisis querrán información sobre:</b><br>" +
                "&#8226; Lo sucedido.<br>" +
                "&#8226; La situación de sus seres queridos y de otros que han sido afectados. <br>" +
                "&#8226; Su seguridad.<br>" +
                "&#8226; Sus derechos.<br>" +
                "&#8226; Cómo acceder a los servicios y cosas en general que necesitan." +

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
        ayudaPsicologica.add(new AtencionesEmergencias(R.drawable.ayuda_psicologica1,psicologico1, "Ayuda Psicológicas", preguntaPap));
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

//------------------------------------------------------------------------------------------------------------------------------------


        primerosAuxilios.add(new PrimerosAuxilios("¿Qué puedes hacer al momento de una fractura?","Atención de Fracturas", R.drawable.fracturalist, fractura));
        primerosAuxilios.add(new PrimerosAuxilios("¿Qué puedes hacer al momento de una hemorragia?", "Atención Hemorrágias", R.drawable.hemorragialist, hemorrageas));
        primerosAuxilios.add(new PrimerosAuxilios("¿Qué puedes hacer al momento de sufrir una herida?", "Atención de Heridas", R.drawable.heridas_icon, heridas));
        primerosAuxilios.add(new PrimerosAuxilios("¿Cómo debes actuar durante una emergencia?", "Primeros Auxilios Psicológicos ", R.drawable.inmo_icon, ayudaPsicologica));
        primerosAuxilios.add(new PrimerosAuxilios("¿Cómo debes actuar durante una emergencia?", "Sistema de Manejo de Emergencias", R.drawable.manejo, comandosEmergencias));
    }


}
