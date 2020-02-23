package Exercise.di;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {
    private String id;
    private String className;
    private List<ConstructorArg> constructorArgs = new ArrayList();
    private Scope scope = Scope.PROTOTYPE;
    private boolean lazyInit = false;

    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public Boolean isSingleton() {
        return scope.equals(Scope.SINGLETON);
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void addConstructorArg(ConstructorArg constructorArg) {
        this.constructorArgs.add(constructorArg);
    }

    // getter && setter
    public void setScope(Scope scope) {
        this.scope = scope;
    }
    public void setLazyInit(Boolean lazyInit) {
        this.lazyInit = lazyInit;
    }
    public String getId() {
        return id;
    }
    public String getClassName() {
        return className;
    }
    public List<ConstructorArg> getConstructorArgs() {
        return constructorArgs;
    }


    // Static Below
    public static enum Scope {
        SINGLETON,
        PROTOTYPE
    }

    public static class ConstructorArg {
        private boolean isRef = false;
        private Class type;
        private Object arg;

        public void setRef(boolean ref) {
            isRef = ref;
        }
        public void setType(Class type) {
            this.type = type;
        }
        public void setArg(Object arg) {
            this.arg = arg;
        }
        public boolean isRef() {
            return isRef;
        }
        public Class getType() {
            return type;
        }
        public Object getArg() {
            return arg;
        }
    }
}
