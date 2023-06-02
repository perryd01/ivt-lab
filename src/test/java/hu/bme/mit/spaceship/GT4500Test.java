package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore primaryTorpedoMock;
  private TorpedoStore secondaryTorpedoMock;

  @BeforeEach
  public void init(){
    this.primaryTorpedoMock = mock(TorpedoStore.class);
    this.secondaryTorpedoMock = mock(TorpedoStore.class);
    this.ship = new GT4500(primaryTorpedoMock, secondaryTorpedoMock);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(primaryTorpedoMock.fire(1)).thenReturn(true);
    when(secondaryTorpedoMock.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(primaryTorpedoMock, times(1)).fire(1);
    verify(secondaryTorpedoMock, times(0)).fire(1);
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(primaryTorpedoMock.fire(1)).thenReturn(true);
    when(secondaryTorpedoMock.fire(1)).thenReturn(true);
    when(primaryTorpedoMock.isEmpty()).thenReturn(false);
    when(secondaryTorpedoMock.isEmpty()).thenReturn(false);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(primaryTorpedoMock, times(1)).isEmpty();
    verify(secondaryTorpedoMock, times(1)).isEmpty();
    verify(primaryTorpedoMock, times(1)).fire(1);
    verify(secondaryTorpedoMock, times(1)).fire(1);
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_Test_1(){
    // Arrange
    when(primaryTorpedoMock.fire(1)).thenReturn(false);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(primaryTorpedoMock, times(1)).fire(1);
    verify(secondaryTorpedoMock, times(0)).fire(1);
    assertEquals(false, result);
  }

  @Test
  public void fireTorpedo_Test_2(){
    // Arrange
    when(primaryTorpedoMock.fire(1)).thenReturn(false);
    when(secondaryTorpedoMock.isEmpty()).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);
    result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(primaryTorpedoMock, times(2)).fire(1);
    verify(secondaryTorpedoMock, times(0)).fire(1);
  }

  @Test
  public void fireTorpedo_Test_3(){
    // Arrange
    when(primaryTorpedoMock.isEmpty()).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(primaryTorpedoMock, times(0)).fire(1);
    verify(secondaryTorpedoMock, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_Test_4(){
    // Arrange
    when(primaryTorpedoMock.isEmpty()).thenReturn(true);
    when(secondaryTorpedoMock.isEmpty()).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(primaryTorpedoMock, times(0)).fire(1);
    verify(secondaryTorpedoMock, times(0)).fire(1);
  }

  @Test
  public void fireTorpedo_Test_5(){
        // Arrange
        when(primaryTorpedoMock.isEmpty()).thenReturn(true);
        when(secondaryTorpedoMock.fire(2)).thenReturn(true);
    
        // Act
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);
        result = ship.fireTorpedo(FiringMode.SINGLE);
    
        // Assert
        verify(primaryTorpedoMock, times(0)).fire(1);
        verify(secondaryTorpedoMock, times(2)).fire(1);
  }

  @Test
  public void fireTorpedo_Test_6(){
            // Arrange
            when(primaryTorpedoMock.fire(1)).thenReturn(true);
            when(secondaryTorpedoMock.fire(1)).thenReturn(true);
        
            // Act
            boolean result = ship.fireTorpedo(FiringMode.SINGLE);
            result = ship.fireTorpedo(FiringMode.SINGLE);
        
            // Assert
            verify(primaryTorpedoMock, times(1)).fire(1);
            verify(secondaryTorpedoMock, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_Test_7(){
    boolean result = ship.fireLaser(FiringMode.SINGLE);

    assertEquals(false, result);
  }

  public void fireTorpedo_Test_8(){

  }

}
