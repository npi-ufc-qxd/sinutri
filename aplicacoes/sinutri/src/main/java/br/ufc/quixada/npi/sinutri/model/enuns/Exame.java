package br.ufc.quixada.npi.sinutri.model.enuns;

public enum Exame {
	
	ACIDOFOLICO("Ácido Fólico", "ng/dL"), 
	ACIDOLATICO("Ácido Lático", "mg/dL"), 
	ACIDOURICO("Ácido Úrico", "mg/dL"), 
	ALBUMINA("Albumina", "g/cem mL"), 
	AMILASE("Amilase", "U/I"), 
	APOPROTEINAA1("Apoproteína A-1", "mg/dL"), 
	APOPROTEINAB100("Apoproteína B-100", "mg/dL"), 
	BASOFILOS("Basófilos", "cel/mm³"), 
	BETACAROTENO("Beta Caroteno", "mg/dL"), 
	BILIRRUBINAD("Bilirrubina Direta", "mg/dL"), 
	BILIRRUBINAI("Bilirrubina Indireta", "mg/dL"), 
	BILIRRUBINAT("Bilirrubina Total", "mg/dL"), 
	CHCM("C.H.C.M.", "%"), 
	CALCIO("Calcio", "mg/dL"), 
	COLHDL("Colesterol HDL", "mg/dL"), 
	COLLDL("Colesterol LDL", "mg/dL"), 
	COLESTEROLTOTAL("Colesterol Total", "mg/dL"), 
	COLVLDL("Colesterol VLDL", "mg/dL"), 
	CORTISOL("Cortisol", "µg/dL"), 
	CREATININA("Creatinina", "mg/dL"), 
	DHT("DHT", "ng/mL"), 
	EOSINOFILOS("Eosinófilos", "cel/mm³"), 
	ESTRADIOL("Estradiol", "ng/dL"), 
	ESTRONA("Estrona", "ng/dL"), 
	FERRITINA("Ferritina", "ng/dL"), 
	FERRO("Ferro", "µg/dL"), 
	FHS("FHS", "mUI/mL"), 
	FOSFORO("Fósforo", "mg/dL"), 
	FRUTOSAMINA("Frutosamina", "µmol/L"), 
	GAMAGT("Gama-Glutamil Transferase (GGT)", "U/L"), 
	GLICOSE("Glicose", "mg/dL"), 
	GLOBULINA("Globulina", "mg/mL"), 
	HCM("H.C.M.", "pg"), 
	HEMACIAS("Hemácias", "mi/mm³"), 
	HEMATOCRITO("Hematócrito", "%"), 
	HEMOGLOBINA("Hemoglobina", "g/dL"), 
	PERCENTHEMOGLOBINA("Hemoglobina (%)", "%"), 
	IGF1("IGF-I", "ng/mL"), 
	INDICECASTELLI1("Índice de Castelli I", "mg/dL"), 
	INDICECASTELLI2("Índice de Castelli II", "mg/dL"), 
	INSULINA("Insulina", "μIU/mL"), 
	LEPTINA("Leptina", "ng/mL"), 
	LEUCOCITOS("Leucócitos", "leucócitos/mm³"), 
	LH("LH", "mUI/mL"), 
	LINFOCITOS("Linfócitos", "cel/mm³"), 
	LIPOPROTEINA("Lipoproteína (A) (LPA)", "mg/dL"), 
	MAGNESIO("Magnésio", "mg/dL"), 
	MANGANES("Manganês", "µg/L"), 
	MONOCITOS("Monócitos", "cel/mm³"), 
	BASTOES("Neutrófilos Bastonetes", "cel/mm³"), 
	SEGMENTARES("Neutrófilos Segmentados", "cel/mm³"), 
	PLAQUETAS("Plaquetas", "plaquetas/mm³"), 
	POTASSIO("Potássio", "mEq/L"), 
	PROLACTINA("Prolactina", "ng/mL"), 
	PROTCREATIVA("Proteína C Reativa (PCR)", "mg/L"), 
	PROTEINASTOTAIS("Proteínas Totais", "g/dL"), 
	PTH("PTH", "pg/mL"), 
	SODIO("Sódio", "mEq/L"), 
	T3("T3", "ng/dL"), 
	T3LIVRE("T3 Livre", "ng/dL"), 
	T4("T4", "ng/dL"), 
	T4LIVRE("T4 Livre", "ng/dL"), 
	TESTOSTERONALIVRE("Testosterona Livre", "pmol/l"), 
	TESTOSTERONATOTAL("Testosterona Total", "ng/dL"), 
	TGO("TGO", "U/L"), 
	TGP("TGP", "U/L"), 
	TRANSFERRINA("Transferrina", "%"), 
	TRIGLICERIDES("Triglicerídios", "mg/dL"), 
	TSH("TSH", "UI/mL"), 
	UREIA("Uréia", "mg/dL"), 
	VCM("V.C.M.", "dL"), 
	VITAMINAA("Vitamina A", "mg/L"), 
	VITAMINAB1("Vitamina B1", "mcg/L"), 
	VITAMINAB12("Vitamina B12", "pg/mL"), 
	VITAMINAB2("Vitamina B2", "ng/mL"), 
	VITAMINAB3("Vitamina B3", "mcg/L"), 
	VITAMINAB5("Vitamina B5", "mcg/L"), 
	VITAMINAB6("Vitamina B6", "mcg/L"), 
	VITAMINAB8("Vitamina B8", "ng/L"), 
	VITAMINAC("Vitamina C", "mg/L"), 
	VITAMINAD("Vitamina D", "ng/mL"), 
	VITAMINAE("Vitamina E", "mg/L"), 
	VITAMINAK("Vitamina K", "ng/mL"), 
	ZINCO("Zinco", "µg/dL");
	
	private String nome;
	private String unidadeMedida;
	
	private Exame(String nome, String unidadeMedida) {
		
		this.nome = nome;
		this.unidadeMedida = unidadeMedida;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	@Override
	public String toString() {
		
		return "Exame " + nome + " medido em " + unidadeMedida;
		
	}
	
}