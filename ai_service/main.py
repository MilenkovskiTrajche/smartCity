from fastapi import FastAPI
from pydantic import BaseModel
from transformers import pipeline

app = FastAPI()

# Mozhe da se loadne i modelo od Colab primerot, ama e pogolem mnogu (distilbert/facebook-bart)
classifier = pipeline("zero-shot-classification", model="valhalla/distilbart-mnli-12-1")

CANDIDATE_LABELS = ["voda", "struja", "dupka", "ulica", "otpad", "osvetluvanje"]

INSTITUTION_MAP = {
    "voda": "Vodovod i Kanalizacija",
    "struja": "EVN / ESM",
    "dupka": "JP Ulici i Patista",
    "ulica": "Opstina Skopje",
    "otpad": "Komunalna Higiena",
    "osvetluvanje": "Gradsko Osvetluvanje"
}

class AiRequest(BaseModel):
    description: str

@app.post("/classify")
async def classify_report(request: AiRequest):
    result = classifier(request.description, candidate_labels=CANDIDATE_LABELS)

    category = result['labels'][0]
    score = result['scores'][0]

    priority = "MEDIUM"
    if score > 0.8 or any(word in request.description.lower() for word in ["itno", "opasno", "poplava", "pozhar"]):
        priority = "HIGH"
    elif score < 0.4:
        priority = "LOW"

    return {
        "category": category,
        "priority": priority,
        "institution": INSTITUTION_MAP.get(category, "Opstina"),
        "summary": f"Detected {category} issue with {int(score*100)}% confidence."
    }

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000)