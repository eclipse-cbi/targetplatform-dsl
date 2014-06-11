package fr.obeo.releng.targetplatform.tests;

import java.net.URI;
import java.util.List;

@SuppressWarnings("all")
public interface IQueryResultProvider<T extends Object> {
  public abstract List<T> listIUs(final URI location);
}
