package tive.music.base;

/**
 *
 * Enumerado que sirve para definir las 7 notas musicales basicas
 * 
 * @author tive
 * @version 1.0
 */
public enum EStepPitch {

    C(1, 2),
    D(2, 2),
    E(3, 1),
    F(4, 2),
    G(5, 2),
    A(6, 2),
    B(7, 1);
    private final int mValue;
    private final int mNextPitchSemitones;

    EStepPitch(int value, int nextPitchSemitones) {
        mValue = value;
        mNextPitchSemitones = nextPitchSemitones;
    }

    /**
     * @return El valor de la altura de la nota en la escala
     */
    public int getValue() {
        return mValue;
    }

    /**
     * @return Los semitonos a la siguiente altura de la nota
     */
    public int getNextPitchSemitones() {
        return mNextPitchSemitones;
    }

    /**
     * @return Una nota aleatoria dentro la escala
     */
    public static EStepPitch random() {
        EStepPitch[] step = values();
        return step[(int) (Math.random() * step.length)];
    }

    public static EStepPitch toEstepPitch(int value) {
        switch (value) {
            case 1:
                return C;
            case 2:
                return D;
            case 3:
                return E;
            case 4:
                return F;
            case 5:
                return G;
            case 6:
                return A;
            case 7:
                return B;
            default:
                assert false;
                return C;
        }
    }

    public EStepPitch next()// codigo repetido fijarse todos los next y previos.. todo es repetido refactor
    {
        if (this == EStepPitch.B) {
            return EStepPitch.C;
        }

        boolean next = false;
        for (EStepPitch step : values())//mas lento pero mas facil de hacer faltativ
        {
            if (next) {
                return step;
            }

            if (step == this) {
                next = true;
            }
        }

        return this;

    }

    public EStepPitch previous()// codigo repetido
    {
        if (this == EStepPitch.C) {
            return EStepPitch.B;
        }

        boolean next = false;
        EStepPitch[] types = values();

        for (int i = types.length - 1; i >= 0; i--)//mas lento pero mas facil de hacer faltativ
        {
            if (next) {
                return types[i];
            }

            if (types[i] == this) {
                next = true;
            }
        }

        return this;
    }
}
