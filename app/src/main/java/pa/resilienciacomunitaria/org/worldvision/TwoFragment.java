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

        String contenidoFractura1="Es la ruptura parcial o total de un hueso lesiones causadas por factores externos o internos como enfermedades propias de los huesos." +
                "\nAgentes externos: Son provocados por trauma, fuerza desproporcionada, movimiento desmedido que ocasionan esgunces, fractura y luxaciones." +
                "\n" +
                "Agentes Internos: Enfermedades que afectan el sistema óseo, eje. Osteoporosis, leucemia y cáncer de huesos";
        String contenidoFractura2="\nSignos y Sintomas de Fracturas: " +
                "\nSignos:" +
                "\n-Deformidad. \n-Inflamación. \n-Incapacidad de movimiento. \n-Aumento o acortamiento del miembro. \n-Área lesionada  enturmecida y Fría. \n-La piel tiene un color Azul. ";


            String contenidoFractura3="Los huesos y articulaciones fracturadas o lesionadas deben ser inmobilizados para que de esta forma" +
                    " puedan prevenir mayores lesiones y diminuir el dolor." +
                    "\n" +
                    "\n En la atención de estas lesiones se utilizan: férulas, vendas de rollo y vendas triangulares.";

        String contenidoFractura4="Un entablillado puede ser preparado comercialmente o improvizado. tambien es posible utilizar una parte del cuerpo que no se encuentre lesionada, por  ejemplo: La otra pierna o el costado del cuerpo.";

        String contenidoFractura5="\n1. No haga nada que le cause mas dolor a la persona." +
                "\n2. Inmobilice el área lesionada en posición de mayor comodidad." +
                "\n3. Examine la circulación distal antes y despues de la inmobilización." +
                "\n3. Tranquilizar a la persona afectada." +
                "\n4. Visualizar la fractura y estabilizar manualmente." +
                "\n5. Seleccionar el material de inmobilización adecuado.";

        ArrayList<Respuestas>  respuestaFractura = new ArrayList<Respuestas>();
        respuestaFractura.add(new Respuestas("Perdida de visión", false));
        respuestaFractura.add(new Respuestas("Dolor intenso en el área afectada", true));
        respuestaFractura.add(new Respuestas("Pérdida de audición", false));


        Preguntas preguntaFractura = new Preguntas("Síntomas de una fractura", respuestaFractura);

        ArrayList<AtencionesEmergencias>  fractura = new ArrayList<AtencionesEmergencias>();
        fractura.add(new AtencionesEmergencias(R.drawable.fractura1, contenidoFractura1, "FRACTURAS", preguntaFractura));
        fractura.add(new AtencionesEmergencias(R.drawable.fractura1, contenidoFractura2, null, preguntaFractura));
        fractura.add(new AtencionesEmergencias(R.drawable.fractura1, contenidoFractura3, "Primeros auxilios para fracturas", preguntaFractura));
        fractura.add(new AtencionesEmergencias(R.drawable.inmobilizacioninfo1, contenidoFractura4, "Inmobilización", preguntaFractura));
        fractura.add(new AtencionesEmergencias(R.drawable.inmobilizacioninfo2, contenidoFractura5, null, preguntaFractura));
//------------------------------------------HEmorragia-------------------------------------------------------------------------
        String hemorragea1="Es la pérdida abundante de sangre al romperse un vaso sanguineo" +
                "\nTIPOS DE HEMORRAGIAS: " +
                "\n1. Hemorragia Arterial: Sangre de color rojo que sale de forma intermitente coincidiendo con los latidos del corazón." +
                "\n2. Hemorragias Venosas: Sangre de color oscuro y que sale de forma continua." +
                "\n3. Hemorragia Capilar: Sangrado de color  rojo que sale de forma lenta." +
                "\n" +
                "\nClasificación de las Hemorragias: " +
                "\n1. Hemorragia Externa: Se acompaña de una herida en la piel y se observa salida de sangre hacia afuera." +
                "\n2. Hemorragia Interna: El sangrado es interno. Este sangrado puede salir por los orificios naturales del cuerpo, convirtiendose en hemorragia  exteriorizada.";
        String hemorragia2="Haga  presión directa: Use guantes y ejerza presión sobre la herida." +
                "\nElevación: Elevar las extremidades afectadas (piernas o brazos), para aminorar la salida de sangre al sitio de la herida. Si no existen fracturas u objetos ensartados  se elevan las extremidades afectadas a un nivel más alto que el del corazón" +
                "\nPresión Indirecta: Usando la yema de los dedos, la palma de la mano, se apretará en el sitio afectado donde podamos prensar la arteria por donde sale la sangre contra el hueso, a fin de evitar el paso de la sangre.";


        ArrayList<Respuestas>  respuestaHemorragia = new ArrayList<Respuestas>();
        respuestaFractura.add(new Respuestas("Perdida de visión", false));
        respuestaFractura.add(new Respuestas("Dolor intenso en el área afectada", true));
        respuestaFractura.add(new Respuestas("Pérdida de audición", false));


        Preguntas preguntaHemorragia = new Preguntas("Síntomas de una fractura", respuestaFractura);

        ArrayList<AtencionesEmergencias>  hemorrageas = new ArrayList<AtencionesEmergencias>();
        hemorrageas.add(new AtencionesEmergencias(R.drawable.heridas1info, hemorragea1, "HEMORRAGIAS", preguntaHemorragia));
        hemorrageas.add(new AtencionesEmergencias(R.drawable.heridas2info, hemorragia2, "Primeros Auxilios para hemorragias", preguntaHemorragia));

//---------------------------------HEridas------------------------------------------------------------------------


        String herida1="Es la separación de los tejidos de la piel, que puede dejar al descubierto otras partes del cuerpo como los huesos y otros órganos del ser humano que se encuentrann internamente.";
        String herida2="\n1. Cortantes: Bordes rectilíneos (cuchillo, gillette, navaja)." +
                "\n2. Lacerantes: Bordes irregulares (latón, sierra, vidrio)." +
                "\n3. Punzantes: Orificio a veces con salida (punzón, clavos, agujas)" +
                "\n3. Contusas: Golpes fuertes (pedradas, martillazos)." +
                "\n4. Corto Punzante: Bordes rectilíneos  y orificio (verruguilla, navaja)." +
                "\n5. Avulsiva: Desgarre o pérdida de un miembro o parte del cuerpo.";


        ArrayList<Respuestas>  respuestaHeridas = new ArrayList<Respuestas>();
        respuestaFractura.add(new Respuestas("Perdida de visión", false));
        respuestaFractura.add(new Respuestas("Dolor intenso en el área afectada", true));
        respuestaFractura.add(new Respuestas("Pérdida de audición", false));


        Preguntas preguntaHerida = new Preguntas("Síntomas de una fractura", respuestaFractura);

        ArrayList<AtencionesEmergencias>  heridas = new ArrayList<AtencionesEmergencias>();
        heridas.add(new AtencionesEmergencias(R.drawable.heridas1info,herida1, "HERIDAS", preguntaHerida));
        heridas.add(new AtencionesEmergencias(R.drawable.heridas2info, herida2, "LOS ELEMENTOS QUE PUEDEN PRODUCIR HERIDAS SON: ", preguntaHerida));


        //Primeros auxilios psicologicos.---------------------------------------------------------------------------

        String psicologico1=" Cuando las personas se enfrentan a  crisis severas derivadas de situaciones vinculadas a desastres naturales o " +
                "producidos por el hombre o ambos, se busca la manera de actuar y tomar mejores decisiones. " +
                "La Psicología de la Emergencia además de auxiliar y guiar a los involucrados para aliviar su sufrimiento procura sobre todo la " +
                "supervivencia y la disminucion máxima de los daños" +
                "\n" +
                "\n¿CÓMO AFECTAN LAS SITUACIONES DE CRISIS A LAS PERSONAS" +
                "\n-La naturaleza y gravedad del /  de los acontecimientos que experimentan. " +
                "\n-Su experiencia con acontecimientos angustiantes anteriores. " +
                "\n-El apoyo de otras personas en su vida. " +
                "\n-Su historia personal y familiar de  problemas de salud mental. " +
                "\n-Su cultura y tradiciones. " +
                "\n-Su edad(por ejemplo, los niños de diferentes edades reaccionan de distintas maneras.) " +
                "\n" +
                "\n¿QUÉ ES LA PRIMERA AYUDA PSICOLÓGICA? " +
                "\nSegún ESFERA (2011) y IASC (2007), la primera ayuda psicológica (PAP) describe una respuesta humana, de apoyo a otros " +
                "seres humanos que están sufriendo y que pueden necesitar ayuda. La PAP trata los siguientes temas: " +
                "\n-Brindar ayuda y apoyo práctico de manera no invasiva " +
                "\n-Evaluar las necesidades y preocupaciones." +
                "\n-Ayuda a las personas a atender sus necesidades básicas." +
                "\n-Escuchar a las personas, pero no presionarlas para que hablen" +
                "\nReconfortar a las personas y ayudarlas a sentirse calmadas";

        String psicologico2="¿QUIÉN, CUÁNDO Y DÓNDE?" +
                "\nLa PAP esta dirigido a personas angustiadas afectadas recientemente por un acontecimiento crítico grave. " +
                "Se puede proporcionar ayuda tanto a niños como a adultos. Sin embargo, no todos los que experimentan una situación de crisis " +
                "necesitarán o querrán PAP. No se debe forzar la ayuda en aquellos que no la quieren, sino estar disponible para aquellos que puedan desear apoyo." +
                "\n" +
                "\nPERSONAS QUE NECESITAN MAYOR APOYO EXPERTO INMEDIATO" +
                "\n-Personas con lesiones graves que ponen en riesgo la vida y que necesitan atencion médica urgente. " +
                "\n-Personas que están alteradas que no pueden ocuparse de sí mismas o de sus hijos. " +
                "\n-Personas que pueden hacerse daños a sí mismas o a otros. " +
                "\n" +
                "\n¿CUÁNDO SE PROPORCIONA LA PRIMERA AYUDA PSICOLÓGICA?" +
                "\nPuede facilitar PAP tan pronto como establezca contacto con personas que estan en situaciones de angustia." +
                "\nNormalente esto será durante o inmediatamente después del acontecimiento. Sin embargo, a veces puede ser días o semanas después" +
                " del acontecimiento dependiendo de cuánto ha durado o grave ha sido el acontecimiento " +
                "\n" +
                "\n" +
                "\n¿DÓNDE SE PUEDE PROPORCIONAR PRIMERA AYUDA PSICOLÓGICA? " +
                "\nLo ideal sería proporcionar PAP en un lugar donde exista cierta privacidad para hablar con la persona cuando se considere oportuno. " +
                "Para personas expuestas a ciertos tipos de acontecimiento críticos, como violencia sexual, la privacidad es esencial para la  confidencialidad " +
                "y el respeto de la dignidad de la persona.";

        String psicologico3="LA AYUDA RESPONSABLE REQUIERE CUATRO ASPECTOS PRINCIPALES: " +
                "\n1. Respetar la seguridad, la dignidad y los derechos" +
                "\n2. Adaptar la propia acción a la cultura de las personas" +
                "\n3. Considerar otras medidas de respuesta a la emergencia." +
                "\n4. Cuidarse a uno mismo. " +
                "\n" +
                "\n¿QUÉ HACER?" +
                "\n- Sea honrado y digno de confianza" +
                "\n- respete el derecho de la gente a tomar sus propias desiciones." +
                "\n- Sea conciente de sus propios prejuicios preferencias, y manténgalos al margen" +
                "\n- Deje claro a la gente que incluso si rechazan la ayuda ahora, podrá recibirla en el futuro." +
                "\n- Respete la privacidad y mantenga la historia de la persona confidencial, salvo imperativos." +
                "\nCompórtese de forma adecuada teniendo en cuenta la cultura, edad y género de la persona" +
                "\n" +
                "\n¿QUE NO HACER?" +
                "\n- No se aproveche de su relación que ayuda." +
                "\n- No pida a la persona dinero o favores a cambio de ayudarle." +
                "\n- No haga falsas promesas o provea información no contrastada." +
                "\n- No exagere sus habilidades." +
                "\n- No fuerce ayuda en la gente, y no sea entrometido o prepotente." +
                "\n- No presione a la gente para que le cuente su historia." +
                "\n- No comparta la historia de una persona con otras personas." +
                "\n- No juzgue a la persona por sus acciones o sentimiento." +
                "\n" +
                "\nSIEMPRE QUE SEA POSIBLE EN RESPUESTA A UNA SITUUACIÓN DE CRISIS" +
                "\n- Siga las indicaciones de las autoridades competentes a cargo de la gestión de la crisis." +
                "\n- Infórmese de las respuestas de emmergencia que están organizando, y de los recursos disponibles " +
                "si existieran para ayudar a las personas." +
                "\n- No estorbe al personal de búsqueda y rescate o al presonal médico de emergencia." +
                "\n- Sea conciente de su rol, y de los límites de su rol.";

        String psicologico4="COMUNICACIÓN ADECUADA" +
                "\nLo que debemos hacer y decir: " +
                "\n- Dé la información de un modo en que la persona la pueda atender, es decir de formas simples." +
                "\n- Hágale saber que comprende, cómo se sienten y que lamenta sus pérdidas y lo que les ha pasado, como haberse quedad sin hogar " +
                "o haber perdido un ser querido." +
                "\n- Hágale saber que reconoce sus fortalezas y la manera en que estan ayudando a sí mismos." +
                "\n- Deje espacios para el silencio." +
                "\n" +
                "\nBRINDE INFORMACIÓN" +
                "\n Las personas afectadas por una situación de crisis querrán información sobre: " +
                "\n- Lo sucedido." +
                "\n- La situación de sus seres queridos y de otros que han sido afectados" +
                "\n- Su seguridad." +
                "\n- Sus derechos." +
                "\n- Cómo acceder a los servicios y cosas en general que necesitan." +
                "\n" +
                "\nPREPARASE A AYUDAR" +
                "\n- Infórmese sobre situaciones de crisis, y las funciones y responsabilidades de los diferentes tipos de personas que están ofreciendo ayuda." +
                "\n- Tenga en cuenta su propia salud." +
                "\n- Decida sinceramente si está o no preparado para ayudar en esta situación determinada de crisis y en este momento concreto.";


        ArrayList<Respuestas>  respuestasPap = new ArrayList<Respuestas>();
        respuestasPap.add(new Respuestas("Juzgar a la persona por sus acciones o sentimiento.", false));
        respuestasPap.add(new Respuestas("Compartir la historia de una persona con otras personas.", false));
        respuestasPap.add(new Respuestas("Respetar el derecho de la gente a tomar sus propias desiciones.", true));


        Preguntas preguntaPap = new Preguntas("¿Qué hacer en una ayuda Psicológica?", respuestasPap);

        ArrayList<AtencionesEmergencias>  ayudaPsicologica = new ArrayList<AtencionesEmergencias>();
        ayudaPsicologica.add(new AtencionesEmergencias(R.drawable.ayuda_psicologica1,psicologico1, "Ayuda Psicológicas", preguntaPap));
        ayudaPsicologica.add(new AtencionesEmergencias(R.drawable.ayuda_psicologica2, psicologico2, "", preguntaPap));
        ayudaPsicologica.add(new AtencionesEmergencias(R.drawable.ayuda_psicologica3, psicologico3, "", preguntaPap));
        ayudaPsicologica.add(new AtencionesEmergencias(R.drawable.ayuda_psicologica4, psicologico4, "", preguntaPap));

        //-------------------------------------Manejo de emergencias-----------------------------------------------------------------

        String manejo1="Es una heramienta de gestion estandarizada para atender5 las demandas en situaciones de emergencias y/o de no emergencia.\n" +
                "- Representa las mejores prácticas del en el tema y ha sido adoptada como el estandar para la gestión de las emergencias en forma global.\n" +
                "- Puede ser usada para planificar eventos, desastres naturales y actos de terrorismo.\n" +
                "\n" +
                "\n¿DÓNDE PUEDO APLICAR?\n" +
                "El sistema de manejo de emergancia busca que bomberos estructurales, forestales, aeronauticos, policia y otros grupos trabajen bajo un mismo sistema, empleando la misma terminología común con una organización definida y regida por procedimientos estandarizados.\n" +
                "En la medida en que las  instituciones aplican estos procedimientos estandarizados en la atención de incidentes cotidianos, pequeños y faciles de solucionar; mejoran su preparacion para trabajar con el sistema el en incidentes de gran magnitud. El SCI  se puede aplicar en:\n" +
                "- Derrumbes, explociones, inundacions, terremotos, huracanes, erupciones volcanicas y tornados.\n" +
                "- Incendios forestales, estructurales, industriales y aeronauticos.\n" +
                "- Accidentes de transporte aéreo, ferroviario, acuatico o terrestre.\n" +
                "- Accidentes domésticos, vehiculares e industriales.\n" +
                "- Misiones de busqueda y operaciones de rescate.\n" +
                "- Icidentes con materiales peligosos.\n" +
                "- tRespuesta a derrames de petróleo.\n" +
                "- tEventos planificados ejemplo. Desfiles, celebraciones, conciertos, plazas públicas.\n";


        String manejo2="PRINCIPOS DEL SISTEMA DE MANEJO DE EMERGENCIAS.\n" +
                "El SCI se basa en principios que permiten asegurar el despliegue rápido, coordinado y efectivo de los recursos y minimizar la alteración de las políticas y procedimientos operativos propio de cada una de las instituciones que espondes\n" +
                "Esos principios son:\n" +
                "- Terminología común.\n" +
                "- Alcance de control.\n" +
                "- Organización modular.\n" +
                "- Comunicaciones integradas.\n" +
                "- Consolidacion de planes en un plan de acción del incidente (PAI).\n" +
                "- Unidad de mano.\n" +
                "- Comando unificado.\n" +
                "- Instalaciones con ubicación determinada y denominación precisa.\n" +
                "- Manejo integral de los recursos.\n" +
                "\n" +
                "\nESTRUCTURA Y FUNCIONES DEL SISTEMA\n" +
                "Cuando en un sistema se necesita el esfuerzo de diferentes instituciones, cualquiera sea la magitud o " +
                "complegidad del mismo o el número de instituciones participantes, se requiere un trabajo coordinado para " +
                "asegurar una respuesta efectiva mediante el uso eficiente y seguro de los recursos.\n";

        String manejo3="\nEL SISTEMA DE MANEJO DE EMERGANCIAS ESTA BASADO EN OCHO (8) FUNCIONES:\n" +
                "- Mando\n" +
                "- Planificación\n" +
                "- Operaciones }logística\n" +
                "- Administracion y finanzas \n" +
                "- Seguridad \n" +
                "- Informacion pública\n" +
                "- Enlace\n" +
                "\n" +
                "\nManejo por objetivos\n" +
                "En el manejo de incidentes, los objetivos respecto a las siguientes prioridaes:\n" +
                "- Salvamento de vidas.\n" +
                "- Estabilización de incidentes.\n" +
                "- Reservacion de la prioridad.\n" +
                "\n" +
                "\nEstablecimiento y transferencias del comando\n" +
                "La función del comando debe establecerse claramente al comienzo de las operaciones de respuestas al incidente. Cuando el comando es " +
                "transferido de una organización o persona a otra, la transferencia debe incluir un periodo de trancisión donde habrá una superposición para garantizar que la tranferencia se dé sin inconvenientes y que no se pierda información importate al realizar el cambio.\n" +
                "\n" +
                "La tranferencia del comand se da cuando:\n" +
                "- Una persona mas calificada asume el mando.\n" +
                "- La situacion del incidente cambia con el tiempo y en consecuencia la ley exige el cambio de comando.\n" +
                "- Hay una cambio normal de personal en incidentes prolongados.\n" +
                "- La respuesta al incidente concluye y la responsabilidad es tranferida al organismo de origen. \n";

        String manejo4="DESPLIEGUE" +
                "\nEl personal Y el equipo deben responder solo cuando lo solicite o lo disponga la autoridad correspondiente." +
                "Evadir los procedimientos establecidos de despliegue solo genera más confusión." +
                "\n" +
                "\nCOMANDO UNIFICADO" +
                "\nEl comando unificado es una estructura que permite que todos los organismos de respuesta trabajen en conjunto, " +
                "compartiendo objetivos y recursos, sin comprometer la autoridad ni la responsabilidad de organismo individual." +
                " La organización sin fines de lucro trabaja a través de una estructura de comando unificado que opera como apoyo, " +
                "al manejo de emergencias, los funcionaros del gobierno y otros trabajadores de respuestas designados." +
                "\nFORMACIÓN DE EQUIPOS" +
                "\nHaz que cada miembro del equipo exponga sus habilidades y experiencias luego. \n" +
                "- Elija la posición de ICS para la que estén más calificados.\n" +
                "- Cada persona del equipo debe cubrir al menos una posición de ICS.\n" +
                "- Una vez hallas elegido a una persona para cubrir cada rol, haz que pongan frente a ellos “el identificador de posiciones ICS”\n" +
                "\nDESCRIPCIÓN DE LAS FUNCIONES: COMANDO DE INCIDENTES \n" +
                "- Establece objetivos, estrategias y prioridades en el incidente.\n" +
                "- Asume toda la responsabilidad por el incidente.\n" +
                "\n" +
                "\nOperaciones\n" +
                "- Define tácticas y recursos para alcanzar los objetivos.\n" +
                "- Dirige la respuesta táctica “alimentación”, atención médica, remoción de escombros, etc.\n" +
                "\nPlanificación\n" +
                "- Recolecta, analiza y evalúa información.\n" +
                "- Gestiona recursos, decide las necesidades para la alimentación y distribución masiva.\n" +
                "- Mantiene la documentación “registro”\n" +
                "\n" +
                "\nLogística \n" +
                "- Provee recursos y servicios necesarios (PODS), servicios necesarios, alimentos.\n" +
                "\nFinanciero administrativo\n";


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


        primerosAuxilios.add(new PrimerosAuxilios("Que puedes hacer al momento de una fractura ","Atencion de Fracturas", R.drawable.fracturalist, fractura));
        primerosAuxilios.add(new PrimerosAuxilios("Que puedes hacer al momento de una hemorragia", "Atencion Hemorrágias", R.drawable.hemorragialist, hemorrageas));
        primerosAuxilios.add(new PrimerosAuxilios("Que puedes hacer al momento de sufrir una herida", "Atención de Heridas", R.drawable.heridas_icon, heridas));
        primerosAuxilios.add(new PrimerosAuxilios("Cómo debes actuar durante una emergencia", "Primeros Auxilios Psicológicos ", R.drawable.inmo_icon, ayudaPsicologica));
        primerosAuxilios.add(new PrimerosAuxilios("Cómo debes actuar durante una emergencia", "Sistema de Manejo de Emergencias", R.drawable.manejo, comandosEmergencias));
    }


}
