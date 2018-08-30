/**
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.eclipse.cbi.targetplatform.ui.contentassist;

import com.google.common.base.Objects;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ProgressMonitorWrapper;
import org.eclipse.swt.widgets.Display;

@SuppressWarnings("all")
public class ReadAndDispatchProgressMonitorWrapper extends ProgressMonitorWrapper {
  private final Display display;
  
  protected ReadAndDispatchProgressMonitorWrapper(final IProgressMonitor monitor, final Display display) {
    super(monitor);
    this.display = display;
  }
  
  @Override
  public void internalWorked(final double work) {
    Thread _currentThread = Thread.currentThread();
    Thread _thread = this.display.getThread();
    boolean _equals = Objects.equal(_currentThread, _thread);
    if (_equals) {
      this.display.readAndDispatch();
      super.internalWorked(work);
      this.display.readAndDispatch();
    } else {
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          ReadAndDispatchProgressMonitorWrapper.super.internalWorked(work);
        }
      };
      this.display.asyncExec(_function);
    }
  }
  
  @Override
  public void subTask(final String name) {
    Thread _currentThread = Thread.currentThread();
    Thread _thread = this.display.getThread();
    boolean _equals = Objects.equal(_currentThread, _thread);
    if (_equals) {
      this.display.readAndDispatch();
      super.subTask(name);
      this.display.readAndDispatch();
    } else {
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          ReadAndDispatchProgressMonitorWrapper.super.subTask(name);
        }
      };
      this.display.asyncExec(_function);
    }
  }
  
  @Override
  public void worked(final int work) {
    Thread _currentThread = Thread.currentThread();
    Thread _thread = this.display.getThread();
    boolean _equals = Objects.equal(_currentThread, _thread);
    if (_equals) {
      this.display.readAndDispatch();
      super.worked(work);
      this.display.readAndDispatch();
    } else {
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
        }
      };
      this.display.asyncExec(_function);
    }
  }
  
  @Override
  public void beginTask(final String name, final int totalWork) {
    Thread _currentThread = Thread.currentThread();
    Thread _thread = this.display.getThread();
    boolean _equals = Objects.equal(_currentThread, _thread);
    if (_equals) {
      this.display.readAndDispatch();
      super.beginTask(name, totalWork);
      this.display.readAndDispatch();
    } else {
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          ReadAndDispatchProgressMonitorWrapper.super.beginTask(name, totalWork);
        }
      };
      this.display.asyncExec(_function);
    }
  }
  
  @Override
  public void setTaskName(final String name) {
    Thread _currentThread = Thread.currentThread();
    Thread _thread = this.display.getThread();
    boolean _equals = Objects.equal(_currentThread, _thread);
    if (_equals) {
      this.display.readAndDispatch();
      super.setTaskName(name);
      this.display.readAndDispatch();
    } else {
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          ReadAndDispatchProgressMonitorWrapper.super.setTaskName(name);
        }
      };
      this.display.asyncExec(_function);
    }
  }
}
