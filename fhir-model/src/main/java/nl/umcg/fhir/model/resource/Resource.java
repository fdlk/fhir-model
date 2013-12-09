package nl.umcg.fhir.model.resource;

public abstract class Resource {
	private Narrative text;

	public void setText(Narrative narrative) {
		this.text = narrative;
	}

	public Narrative getText() {
		return text;
	}
	
	public abstract String getResourceType();
	
}
