package _23_PastExams._2022_12_December_19.magicGame.models.magicians;

import _23_PastExams._2022_12_December_19.magicGame.common.ExceptionMessages;
import _23_PastExams._2022_12_December_19.magicGame.models.magics.Magic;

public abstract class MagicianImpl implements Magician {
    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        this.setUsername(username);
        this.setHealth(health);
        this.setProtection(protection);
        this.setMagic(magic);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        if (this.protection - points < 0) {
            points -= this.protection;
            this.protection = 0;

            if (this.health - points <= 0) {
                this.health = 0;
                this.isAlive = false;

            } else {
                this.health -= points;
            }

        } else {
            this.protection -= points;
        }
    }

    private void setUsername(String username) {
        if (null == username || username.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_NAME);
        }

        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
        }

        this.isAlive = true;
        this.health = health;
    }

    private void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
        }

        this.protection = protection;
    }

    private void setMagic(Magic magic) {
        if (null == magic) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC);
        }

        this.magic = magic;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n" +
                "Health: %d%n" +
                "Protection: %d%n" +
                "Magic: %s",
                this.getClass().getSimpleName(),
                this.getUsername(),
                this.getHealth(),
                this.getProtection(),
                this.getMagic().getName());
    }
}
