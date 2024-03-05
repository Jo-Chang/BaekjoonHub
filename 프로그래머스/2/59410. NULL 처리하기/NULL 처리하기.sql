-- 코드를 입력하세요
SELECT
    ANIMAL_TYPE, 
    IFNull(NAME, "No name"),
    SEX_UPON_INTAKE
FROM
    ANIMAL_INS;